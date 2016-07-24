package songbiandian.servlet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import songbiandian.jdbc.*;
import songbiandian.middleware.TemplateInfo;

/**
 * <tt>FindAllTemplates<tt>类,用于在每次第一次加载试验模板管理界面时,都可以从数据库中取出已经存在的模板数据
 * @author TerenceWu
 *
 */
public class FindAllTemplates extends HttpServlet {
	private static final long serialVersionUID = -3070772532409264103L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<TemplateInfo> templateInfoList = new ArrayList<>();
		String findAllTemplates = "select * from test_report_template_metadata";
		
		DBConn dbConn = DBConn.getInstanceOfDBConn();
		ResultSet resultSet = dbConn.executeQuery(findAllTemplates);
		try {
			while (resultSet.next()) {
				templateInfoList.add(TemplateInfo.getInstanceOfTemplateInfo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
			}
		} catch (SQLException e) {
			System.out.println("查询所有的模板信息出现错误!");
			e.printStackTrace();
		}
		
		session.setAttribute("templateinfolist", templateInfoList);
		
		response.sendRedirect("Sybg_mb.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
