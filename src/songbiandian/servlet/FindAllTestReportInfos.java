package songbiandian.servlet;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import songbiandian.javabean.TestReportMetaData;
import songbiandian.jdbc.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * <tt>FindAllTestReportInfos<tt>类,用于找出数据库中试验报告的信息
 * @author TerenceWu
 *
 */
public class FindAllTestReportInfos extends HttpServlet {
	private static final long serialVersionUID = -2158972459536680031L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String requestFile = request.getParameter("requestfilename");
		
		/**
		 * 用一个ArrayList存储所有的试验报告的元数据信息
		 */
		ArrayList<TestReportMetaData> testReportsList = new ArrayList<>();
		
		DBConn dbConn = DBConn.getInstanceOfDBConn();
		
		String getAllTestReportMetaInfosSql = "select test_report_ID,test_report_name,station_name,equipment_type,test_attribute,test_person,test_date,report_date from test_report_metadata";
		
		ResultSet resultSet = dbConn.executeQuery(getAllTestReportMetaInfosSql);
		
		try {
			while (resultSet.next()) {
				testReportsList.add(TestReportMetaData.getInstanceOfTestReportMetaData(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8)));
			}
		} catch (SQLException e) {
			System.out.println("查询试验报告信息失败!");
			e.printStackTrace();
		}
		
		session.setAttribute("report_test_metainfolist", testReportsList);
		
		/**
		 * 根据请求的页面,跳转到不同的页面
		 */
		if (requestFile.equals("Sybg_gl.jsp")) {
			response.sendRedirect("Sybg_gl.jsp");
		}
		else if (requestFile.equals("Sybg_shh.jsp")) {
			response.sendRedirect("Sybg_shh.jsp");
		}
		else {
			response.sendRedirect("Sybg_tj.jsp");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
