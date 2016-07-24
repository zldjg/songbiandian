package songbiandian.servlet;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import songbiandian.jdbc.*;

/**
 * <tt>NextStep</tt>类,用于在试验报告填写的第一步保存相关数据
 * @author TerenceWu
 *
 */
public class NextStep extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6916953463322430065L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		 * 跳转数据录入界面
		 */
		response.sendRedirect("Sybg_lrnext.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
