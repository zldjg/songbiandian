package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.Dao.UserDao;
import com.entity.User;



public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = (String)request.getParameter("method");
		if(method==null) {
			PrintWriter out = response.getWriter();
			out.println("invalid request!");
		} else if(method.equals("add")) {
			Add(request, response);
		} else if(method.equals("del")){
			Delete(request, response);
		}else if(method.equals("edit")){
			Edit(request, response);
		}else if(method.equals("modify")){
			Modify(request,response);
		}
		
	}
	protected void Add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String groupname = request.getParameter("groupname");
		String rank = request.getParameter("rank");
		String phonenumber = request.getParameter("phonenumber");
		String mobilephone = request.getParameter("mobilephone");
		String email = request.getParameter("email");
		String status = request.getParameter("state");
		int state = 0;
		if(status.equals("禁用")){
			state = 1;
		}
			
		User user = new User();
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setGroup(groupname);
		user.setRank(rank);
		user.setPhonenumber(phonenumber);
		user.setMobilephone(mobilephone);
		user.setEmail(email);
		user.setState(state);
		
		
		UserDao ud = new UserDao();
		try{
			ud.saveUser(user);
		}catch(Exception e){
			e.printStackTrace();
		}
			
			
			
		RequestDispatcher rd = request.getRequestDispatcher("/User_gl.jsp");
		rd.forward(request, response);
		
		 
	}
	protected void Delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException { 
        				
		UserDao ud = new UserDao();		
		
		String id = request.getParameter("userid");
		if(id == null){
			response.sendRedirect("User_gl.jsp");
			return;
		}else{
		String[] idlist = request.getParameterValues("userid");
		int[]  userid=new int[idlist.length];
		for(int i =0;i<idlist.length;i++){
			userid[i] = Integer.parseInt(idlist[i]);
		}
		try{
			ud.deleteUser(userid);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/User_gl.jsp");
		rd.forward(request, response);
		
		 
	}
	}
	
	protected void Edit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userid");
		User user = new User();
		UserDao ud = new UserDao();	
		if(id == null){
			response.sendRedirect("User_gl.jsp");
			return;
		}
		
		try{
			user=ud.getUserById(id);
			request.setAttribute("user", user);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/User_edit.jsp");
		rd.forward(request, response);
		
	}
	protected void Modify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String groupname = request.getParameter("groupname");
		String rank = request.getParameter("rank");
		String phonenumber = request.getParameter("phonenumber");
		String mobilephone = request.getParameter("mobilephone");
		String email = request.getParameter("email");
		String status = request.getParameter("state");
		int userid = Integer.parseInt(request.getParameter("userid"));
		int state = 0;
		if(status.equals("禁用")){
			state = 1;
		}
			
		User user = new User();
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setGroup(groupname);
		user.setRank(rank);
		user.setPhonenumber(phonenumber);
		user.setMobilephone(mobilephone);
		user.setEmail(email);
		user.setState(state);
		user.setUserid(userid);
		
		UserDao ud = new UserDao();		
		try{
			ud.updateUser(user);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/User_gl.jsp");
		rd.forward(request, response);
		
	}
	
}
