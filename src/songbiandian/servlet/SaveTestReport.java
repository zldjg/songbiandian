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
		 */
		response.sendRedirect("Sybg_gl.jsp");
	}
	
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
