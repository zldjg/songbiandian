package songbiandian.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import songbiandian.jdbc.*;

public class FindAllTemplates extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3070772532409264103L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
