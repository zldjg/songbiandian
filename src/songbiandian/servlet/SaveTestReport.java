package songbiandian.servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import songbiandian.jdbc.*;
//import songbiandian.javabean.*;
import songbiandian.middleware.SqlStringProcess;

/**
 * <tt>SavaTestReport</tt>用于存储试验报告的内容
 * @author TerenceWu
 *
 */
public class SaveTestReport extends HttpServlet {
	private static final long serialVersionUID = 2919564878872121775L;
	
	@SuppressWarnings("unchecked")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/**
		 * 数据库相关对象
		 */
		DBConn dbConn = DBConn.getInstanceOfDBConn();
		Connection connection = dbConn.getConnection();
		PreparedStatement preparedStatement = null;
		
		/**
		 * 取出session并且把session中的数据取出来
		 */
		HttpSession session = request.getSession();
		String equipmentName = (String)session.getAttribute("test_equipmentname");
		List<String> projectsList = (List<String>)session.getAttribute("test_projectslist");
		HashMap<String, ArrayList<String>> positionListMap = (HashMap<String, ArrayList<String>>)session.getAttribute("test_positionofprojectmap");
		HashMap<String, HashMap<String, ArrayList<String>>> paramOfProjectMap = (HashMap<String, HashMap<String, ArrayList<String>>>)session.getAttribute("test_paramofprojectmap");
		HashMap<String, ArrayList<String>> paramOfNoPositionMap = (HashMap<String, ArrayList<String>>)session.getAttribute("test_paramofnoposition");
		
		/**
		 * 处理表格主体的部分
		 */
		for (String project : projectsList) {
	 		ArrayList<String> positionListOfProject = positionListMap.get(project);
	 		if (positionListOfProject == null) {
	 			String inputName = equipmentName + "_" + project;
	 			ArrayList<String> paramOfNoPosition = paramOfNoPositionMap.get(project);
	 			if (paramOfNoPosition.size() == 1) {
	 				String requestValue = request.getParameter(inputName);
	 				String insertSql = "insert into " + SqlStringProcess.deleteSpecificChar(inputName, "/").toLowerCase() + "(test_value) values(?)";
	 				try {
						preparedStatement = connection.prepareStatement(insertSql);
						preparedStatement.setString(1, requestValue);
						preparedStatement.executeUpdate();
					} catch (SQLException e) {
						System.out.println("插入数据失败!");
						e.printStackTrace();
					}
	 			}
	 			else {
	 				String[] requestValues = request.getParameterValues(inputName);
	 				String tempOne = SqlStringProcess.generateFormatOne(paramOfNoPosition);
	 				String tempTwo = SqlStringProcess.generateFormatTwo(paramOfNoPosition);
	 				String insertSql = "insert into " + SqlStringProcess.deleteSpecificChar(inputName, "/").toLowerCase() + SqlStringProcess.deleteSpecificChar(tempOne, "/") + " values" + tempTwo;
	 				try {
	 					preparedStatement = connection.prepareStatement(insertSql);
	 					for (int i = 1 ; i <= paramOfNoPosition.size() ; i++) {
	 						preparedStatement.setString(i, requestValues[i-1]);
	 					}
	 					preparedStatement.executeUpdate();
	 				} catch (SQLException e) {
	 					System.out.println("插入数据失败!");
	 					e.printStackTrace();
	 				}
	 			}
	 		}
	 		else {
	 			for (String position : positionListOfProject) {		
	 				HashMap<String, ArrayList<String>> paramOfThisPositionMap = paramOfProjectMap.get(project);
	 				ArrayList<String> paramOfThisPositionList = paramOfThisPositionMap.get(position);
	 				String inputName = equipmentName + "_" + project + "_" + position;
	 				if (paramOfThisPositionList != null) {
	 					if (paramOfThisPositionList.size() == 1) {
	 						String requestValue = request.getParameter(inputName);
	 					   	String insertSql = "insert into " + SqlStringProcess.deleteSpecificChar(inputName, "/").toLowerCase() + "(test_value) values(?)";
	 					   	try {
								preparedStatement = connection.prepareStatement(insertSql);
								preparedStatement.setString(1, requestValue);
								preparedStatement.executeUpdate();
							} catch (SQLException e) {
								System.out.println("插入数据失败!");
								e.printStackTrace();
							}
	 					}
	 					else {
	 					   	System.out.println(inputName);
	 					   		
	 					   	String[] requestValues = request.getParameterValues(inputName);
	 					   		
	 					   	String tempOne = SqlStringProcess.generateFormatOne(paramOfThisPositionList);
	 					   	String tempTwo = SqlStringProcess.generateFormatTwo(paramOfThisPositionList);
	 					   	String insertSql = "insert into " + SqlStringProcess.deleteSpecificChar(inputName, "/").toLowerCase() + SqlStringProcess.deleteSpecificChar(tempOne, "/") + " values" + tempTwo;
	 					   	try {
								preparedStatement = connection.prepareStatement(insertSql);
								for (int i = 1 ; i <= paramOfThisPositionList.size() ; i++) {
									preparedStatement.setString(i, requestValues[i-1]);
								}
								preparedStatement.executeUpdate();
							} catch (SQLException e) {
								System.out.println("插入数据失败!");
								e.printStackTrace();
							}
	 					}
	 				}
	 			}
	 		}
		}
		
		/**
		 * OK,以上就是表格主体的部分，接下来应该处理表格开头的那一部分数据了!
		 * 最困难的部分已经过去!
		 * 首先我们需要获取一些请求参数
		 */
		
		//试验报告名称
		String testReportName = (String) session.getAttribute("testreportname");
		//站名
		String stationName = (String) session.getAttribute("stationname");
		//设备类型
		String equipmentType = (String) session.getAttribute("equipmenttype");
		//试验单位
		String testUnit = request.getParameter("test_unit");
		//试验日期
		String testDate = request.getParameter("test_date");
		//天气
		String weather = (String) session.getAttribute("test_weather");
		//温度
		String temperature = (String) session.getAttribute("test_temperature");
		//湿度
		String humidity = (String) session.getAttribute("test_humidity");
		//试验人员
		String testPerson = request.getParameter("test_person");
		//试验地点
		String testLocation = request.getParameter("test_location");
		//报告日期
		String reportDate = (String) session.getAttribute("report_date");
		//报告人
		String reportPerson = request.getParameter("report_person");
		//审核人
		String assessor = request.getParameter("assessor");
		//批准人
		String approver = request.getParameter("approver");
		//试验型号
		String testModel = request.getParameter("test_model");
		//运行编号
		String runtimeSerialNumber = request.getParameter("runtime_serialnumber");
		//额定电压
		String ratedVoltage = request.getParameter("rated_voltage");
		//额定容量
		String ratedCapacity = request.getParameter("rated_capacity");
		//额定电流
		String ratedCurrent = request.getParameter("rated_current");
		//连接组别
		String connectionGroup = request.getParameter("connection_group");
		//生产厂家
		String manufactureName = request.getParameter("manufacture_name");
		//生产日期
		String manufactureDate = request.getParameter("manufacture_date");
		//安装地点
		String insatllLocation = request.getParameter("install_location");
		//出厂编号
		String manufactureNumber = request.getParameter("manufacture_number");
		
		String insertTestReportTitleSql = "insert into test_report_metadata(test_report_name,station_name,equipment_type,test_attribute,test_person,test_date,report_date,test_unit,report_person,test_approver,test_location,assessor,test_model,runtime_serialnumber,rated_voltage,rated_current,rated_capacity,connection_group,manufacture_name,manufacture_date,install_location,manufacture_number) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(insertTestReportTitleSql);
		} catch (SQLException e) {
			System.out.println("插入数据失败!");
			e.printStackTrace();
		}
		
		response.sendRedirect("Sybg_gl.jsp");
	}
	
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
