package songbiandian.servlet;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import org.dom4j.DocumentException;

import songbiandian.jdbc.*;
import songbiandian.middleware.Parameter;
import songbiandian.middleware.Position;
import songbiandian.middleware.Standard;
import songbiandian.middleware.TestInstrument;

/**
 * <tt>ViewTestReport</tt>类,主要用于插入数据以后查看数据用
 * @author TerenceWu
 *
 */
public class ViewTestReport extends HttpServlet {
	
	private static final long serialVersionUID = 7264215858082223376L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String testReportName = request.getParameter("testreportname");
		
		/**
		 * 用于存放试验项目的List
		 */
		List<String> projectsList = new ArrayList<>();
		/**
		 * 试验报告模板ID
		 */
		int reportTemplateId = 0;
		/**
		 * 模板对应的设备名称
		 */
		String equipmentName = "";
		
		/**
		 * 获取session对象
		 */
		HttpSession session = request.getSession();
		/**
		 * 创建数据库连接对象
		 */
		DBConn dbConn = DBConn.getInstanceOfDBConn();
		/**
		 * 获取数据库连接
		 */
		//Connection connection = dbConn.getConnection();
		
		/**
		 * 设置请求格式
		 */
		request.setCharacterEncoding("UTF-8");
		
		
		//找出模板对应的设备名称sql
		String findEquipmentNameSql = "select test_report_template_equipmentName,test_report_template_ID from test_report_template_metadata where test_report_template_templateName='" + testReportName + "'";
				
		ResultSet resultSet = dbConn.executeQuery(findEquipmentNameSql);
		try {
			while (resultSet.next()) {
				equipmentName = resultSet.getString(1);
				reportTemplateId = resultSet.getInt(2);
			}
		} catch (SQLException e) {
			System.out.println("查找对应的设备名称和模板id出现问题!");
			e.printStackTrace();
		}
		
		//找出模板对应的试验项目的sql
		String findProjectsSql = "select test_projectName from test_report_template_subdata where test_report_template_ID='" + reportTemplateId + "'";
		resultSet = dbConn.executeQuery(findProjectsSql);
		try {
			while (resultSet.next()) {
				projectsList.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("查找对应的试验项目出现问题!");
			e.printStackTrace();
		}
		
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
		
		/**
		 * 接下来,就是解析xml文件了
		 */
		for (String project : projectsList) {
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
		 * 接下来就是把数据放到session中去了
		 */
		session.setAttribute("testreportname", testReportName);
		session.setAttribute("test_equipmentname", equipmentName);
		session.setAttribute("test_projectslist", projectsList);
		session.setAttribute("test_positionofprojectmap", positionOfProject);
		session.setAttribute("test_paramofpositionmap", paramOfPosition);
		session.setAttribute("test_standardMap", projectStandardMap);
		session.setAttribute("test_testinstrumentMap", projectTestInstrumentMap);
		session.setAttribute("test_paramoffirstlinemap", paramOfFirstLineOfProjectMap);
		session.setAttribute("test_paramofprojectmap", paramOfProjectMap);
		session.setAttribute("test_paramofnoposition", paramOfProjectWithNoPosition);
		
		response.sendRedirect("Sybg_details.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
