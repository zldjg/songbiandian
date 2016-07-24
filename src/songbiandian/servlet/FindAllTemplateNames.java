package songbiandian.servlet;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import songbiandian.jdbc.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * <tt>FindAllTemplateNames<tt>类的主要作用是找出数据库中所有的模板名称,并把它们存储在ArrayList中
 * @author TerenceWu
 *
 */
public class FindAllTemplateNames extends HttpServlet {
	private static final long serialVersionUID = -5748227420064754872L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String findAllTemplateNamesSql = "select test_report_template_templateName from test_report_template_metadata";
		
		List<String> templateNamesList = new ArrayList<>();
		
		HttpSession session = request.getSession();
		
		DBConn dbConn = DBConn.getInstanceOfDBConn();
		ResultSet resultSet = dbConn.executeQuery(findAllTemplateNamesSql);
		
		try {
			while (resultSet.next()) {
				templateNamesList.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("查找模板名称时出现问题!");
			e.printStackTrace();
		}
		
		session.setAttribute("templatenameslist", templateNamesList);
		response.sendRedirect("Sybg_lr.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
