package songbiandian.servlet;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
		response.sendRedirect("Sybg_gl.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
