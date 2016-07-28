package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;
import com.entity.*;
import java.util.*;

public class userList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		UserDao ud = new UserDao();
		int pageSize = 3;
		int totalPage = 1;
		try{
			int totalResult = ud.getUser().size();
			 totalPage = (totalResult % pageSize) == 0 ?  totalResult / pageSize : totalResult / pageSize +1;
			
			int pageNow = 1;
					
			String pageNows = request.getParameter("pageNow");
			if(pageNows != null) {
				pageNow = Integer.parseInt(pageNows);
				if(pageNow < 1) pageNow = 1;
				if(pageNow > totalPage) pageNow = totalPage;
			}
					
			ShowRecordByPage page = ud.getUsersByPage(pageNow, pageSize);
						
			request.setAttribute("pages", page);
			request.setAttribute("totalPage", totalPage);
			
		} catch (Exception e) {
			throw new ServletException();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/User_gl.jsp");
		rd.forward(request, response);
}
}
