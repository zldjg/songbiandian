package songbiandian.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.dom4j.DocumentException;

import songbiandian.middleware.*;
import songbiandian.jdbc.*;

/**
 * <tt>GenerateTestReportTemplate</tt>类用于根据前台设备信息和项目信息从config.xml以及standard.xml文件中读取相关数据,
 * 并把这些数据存储在<tt>ArrayList</tt>以及<tt>HashMap</tt>中
 * @author TerenceWu
 *
 */
@SuppressWarnings("serial")
public class GenerateTestReportTemplate extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/**
		 * 设置日期格式
		 */
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/**
		 * 一个ArrayList,用于存储模板信息
		 */
		List<TemplateInfo> templateInfoList = new ArrayList<>();
		/**
		 * 试验模板名称
		 */
		String templateName = request.getParameter("templatename");
		/**
		 * 设备类型
		 */
		String equipmentType = request.getParameter("equipmenttype");
		/**
		 * 设备名称
		 */
		String equipmentName = request.getParameter("equipment");
		
		/**
		 * 试验项目数组
		 */
		String[] projects = request.getParameterValues("project");
		
		/**
		 * 位置信息ArrayList
		 */
		ArrayList<String> positionList = new ArrayList<>();
		
		/**
		 * 每个project对应一个存放了该project对应的positionList
		 */
		HashMap<String, ArrayList<String>> positionOfProject = new HashMap<>();
		/**
		 * 每个试验项目都有具体的标准,HashMap存储一个<project,standard>的键值对
		 */
		HashMap<String, String> projectStandardMap = new HashMap<>();
		/**
		 * 每个试验项目都有具体的试验仪器,HashMap存储一个<project,testInstrument>的键值对
		 */
		HashMap<String, String> projectTestInstrumentMap = new HashMap<>();
		/**
		 * 每个position都对应一个存放了parameter信息的List
		 */
		HashMap<String, ArrayList<String>> paramOfPosition = new HashMap<>();
		/**
		 * 每一个试验项目都用一个ArrayList来存储该项目试验报告第一行参数
		 */
		ArrayList<String> paramOfFirstLineList = new ArrayList<>();
		/**
		 * 一个project对应一个第一行参数表,把这两个信息作为一个键值对
		 */
		HashMap<String, ArrayList<String>> paramOfFirstLineOfProjectMap = new HashMap<>();
		
		HashMap<String, HashMap<String, ArrayList<String>>> paramOfProjectMap = new HashMap<>();
		
		HashMap<String, ArrayList<String>> paramOfProjectWithNoPosition = new HashMap<>();
		
		DBConn dbConn = DBConn.getInstanceOfDBConn();
		PreparedStatement preparedStatement = null;
		Connection connection = dbConn.getConnection();
		
		TemplateInfo templateInfo = TemplateInfo.getInstanceOfTemplateInfo();
		
		String sqlInfo1 = "insert into test_report_template_metadata(test_report_template_templateName,test_report_template_equipmentType,test_report_template_equipmentName,test_report_template_addedTime) values(?,?,?,?)";
		String sqlInfo2 = "insert into test_report_template_subdata(test_report_template_ID,test_projectName) values(?,?)";
		String getTemplateIdSql = "select * from test_report_template_metadata where test_report_template_equipmentName='" + equipmentName + "'";
		try {
			preparedStatement = connection.prepareStatement(sqlInfo1);
			preparedStatement.setString(1, templateName);
			preparedStatement.setString(2, equipmentType);
			preparedStatement.setString(3, equipmentName);
			preparedStatement.setString(4, dateFormat.format(new Date()));
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = dbConn.executeQuery(getTemplateIdSql);
			while (resultSet.next()) {
				templateInfo.setTemplateId(resultSet.getInt(1));
				templateInfo.setTemplateName(resultSet.getString(2));
				templateInfo.setEquipmentType(resultSet.getString(3));
				templateInfo.setEquipmentName(resultSet.getString(4));
				templateInfo.setTemplateAddedTime(resultSet.getString(5));
				/**
				 * 把这个templateInfo放入ArrayList
				 */
				templateInfoList.add(templateInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (String project : projects) {
			try {
				preparedStatement = connection.prepareStatement(sqlInfo2);
				preparedStatement.setInt(1, templateInfo.getTemplateId());
				preparedStatement.setString(2, project);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			/**
			 * 对每个project,找到对应的positionList,存储为一个<proejct,positionList>键值对
			 */
			try {
				positionList = Position.getPositions(equipmentName, project);
				positionOfProject.put(project, positionList);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			
			
			
			if (positionList != null) {
				try {
					paramOfFirstLineList = Parameter.getParameters(equipmentName, project, positionList.get(0));
					paramOfFirstLineOfProjectMap.put(project, paramOfFirstLineList);
				} catch (DocumentException e) {
					e.printStackTrace();
				}
				/**
				 * 前面已经得到该project对应的positionList,现在对于每一个position,找出对应的参数列表paramOfPositionList
				 */
				for (String position : positionList) {
					try {
						ArrayList<String> paramOfPositionList = Parameter.getParameters(equipmentName, project, position);
						/**
						 * 对于每一个position,用HashMap存储<position,paramOfPositionList>键值对
						 */
						paramOfPosition.put(position, paramOfPositionList);
					} catch (DocumentException e) {
						e.printStackTrace();
					}
				}
			}
			/**
			 * 接下来解决没有position的情形
			 */
			else {
				try {
					ArrayList<String> paramOfProjectList = Parameter.getParamOfNoPosition(equipmentName, project);
					paramOfProjectWithNoPosition.put(project, paramOfProjectList);
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
			
			/**
			 * 对于每一个project,获取对应的标准和试验仪器,放入对应的HashMap中
			 */
			try {
					projectStandardMap.put(project, Standard.getStandard(equipmentName, project));
					projectTestInstrumentMap.put(project, TestInstrument.getTestInstrument(equipmentName, project));
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			
			/**
			 * 每一个试验项目，对应一个HashMap,这个HashMap里存储的是每个position对应的参数列表
			 */
			paramOfProjectMap.put(project, paramOfPosition);
		}
		
		/**
		 * 获取session
		 */
		HttpSession session = request.getSession();
		/**
		 * 把相关对象放入session中去
		 */
		session.setAttribute("equipmentname", equipmentName);
		session.setAttribute("templatename", templateName);
		session.setAttribute("projectstring", projects);
		session.setAttribute("positionofprojectmap", positionOfProject);
		session.setAttribute("paramofpositionmap", paramOfPosition);
		session.setAttribute("standardMap", projectStandardMap);
		session.setAttribute("testinstrumentMap", projectTestInstrumentMap);
		session.setAttribute("paramoffirstlinemap", paramOfFirstLineOfProjectMap);
		session.setAttribute("paramofprojectmap", paramOfProjectMap);
		session.setAttribute("paramofnoposition", paramOfProjectWithNoPosition);
		session.setAttribute("templateinfolist", templateInfoList);
		/**
		 * 跳转到Sybg_mbdetails.jsp
		 */
		//response.sendRedirect("generatetestreport.jsp");
		response.sendRedirect("Sybg_mbdetails.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
