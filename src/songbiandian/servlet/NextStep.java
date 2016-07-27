package songbiandian.servlet;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * <tt>NextStep</tt>类,用于在试验报告填写的第一步保存相关数据,并且根据试验模板的名称,需要找出该模板对应的相关参数
 * @author TerenceWu
 *
 */
public class NextStep extends HttpServlet {
	
	private static final long serialVersionUID = 6916953463322430065L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 设置日期格式
		 */
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String currentDate = dateFormat.format(new Date());
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
		Connection connection = dbConn.getConnection();
		
		/**
		 * 设置请求格式
		 */
		request.setCharacterEncoding("UTF-8");
		/**
		 * 前期准备工作,把必须的参数都找出来
		 */
		//所属站房
		String stationName = request.getParameter("stationname");
		//电压等级
		String voltageScale = request.getParameter("voltage");
		//设备类型
		String equipmentType = request.getParameter("equipmenttype");
		//设备名称
		String specialEquipmentName = request.getParameter("equipmentname");
		//试验性质
		String testAttribute = request.getParameter("testattribute");
		//试验天气
		String weather = request.getParameter("weather");
		//温度
		String temperature = request.getParameter("temperature");
		//湿度
		String humidity = request.getParameter("humidity");
		//模板名称
		String reportTemplateName = request.getParameter("reporttemplate");
		
		/**
		 * 负责把前期数据存储进试验报告表头临时数据的SQL语句
		 */
		String insertReportTitleTemp = "insert into test_report_title_temp(station_name,voltage_rank,equipment_type,equipment_name,test_attribute,weather,temperature,humidity) values(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertReportTitleTemp);
			preparedStatement.setString(1, stationName);
			preparedStatement.setString(2, voltageScale);
			preparedStatement.setString(3, equipmentType);
			preparedStatement.setString(4, specialEquipmentName);
			preparedStatement.setString(5, testAttribute);
			preparedStatement.setString(6, weather);
			preparedStatement.setString(7, temperature);
			preparedStatement.setString(8, humidity);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/**
		 * 接下来的工作是最为关键的,需要通过模板名称把该模板相关的设备信息、试验项目信息以及对应的位置和参数信息全部找出来
		 */
		//找出模板对应的设备名称sql
		String findEquipmentNameSql = "select test_report_template_equipmentName,test_report_template_ID from test_report_template_metadata where test_report_template_templateName='" + reportTemplateName + "'";
		
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
		 * OK,到这步为止，所有需要的数据都齐全了
		 * 1.模板名称 reportTemplateName
		 * 2.设备名称 equipmentName
		 * 3.试验项目List:projectsList
		 * 接下来,便是重复生成模板的步骤了
		 * 首先是各种数据结构,用于存储相关信息
		 */
		
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
		session.setAttribute("testreporttemplatename", reportTemplateName);
		session.setAttribute("stationname", stationName);
		session.setAttribute("equipmenttype", equipmentType);
		session.setAttribute("test_equipmentname", equipmentName);
		session.setAttribute("test_projectslist", projectsList);
		session.setAttribute("test_positionofprojectmap", positionOfProject);
		session.setAttribute("test_paramofpositionmap", paramOfPosition);
		session.setAttribute("test_standardMap", projectStandardMap);
		session.setAttribute("test_testinstrumentMap", projectTestInstrumentMap);
		session.setAttribute("test_paramoffirstlinemap", paramOfFirstLineOfProjectMap);
		session.setAttribute("test_paramofprojectmap", paramOfProjectMap);
		session.setAttribute("test_paramofnoposition", paramOfProjectWithNoPosition);
		session.setAttribute("report_date", currentDate);
		session.setAttribute("test_weather", weather);
		session.setAttribute("test_temperature", temperature);
		session.setAttribute("test_humidity", humidity);
		session.setAttribute("test_attribute", testAttribute);
		
		/**
		 * 跳转数据录入界面
		 */
		response.sendRedirect("Sybg_lrnext.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
