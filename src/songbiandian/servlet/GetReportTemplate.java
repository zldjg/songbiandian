package songbiandian.servlet;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import songbiandian.jdbc.*;
//import songbiandian.javabean.*;

/**
 * <tt>GetReportTemplate</tt>类,用于从数据库中读取出试验报告模板的信息
 * @author TerenceWu
 *
 */
@SuppressWarnings("serial")
public class GetReportTemplate extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 用ArrayList存储所有的模板名称信息
		 */
		ArrayList<String> reportTemplateNameList = new ArrayList<>();
		
		DBConn dbConn = DBConn.getInstanceOfDBConn();
		
		String sql = "select mb_name from sybg_mb";
		
		ResultSet resultSet = dbConn.executeQuery(sql);
		
		try {
			while (resultSet.next()) {
				reportTemplateNameList.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("reporttemplatenamelist", reportTemplateNameList);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
