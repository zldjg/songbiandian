package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.*;
import com.Dao.*;

public class managroupServlet extends HttpServlet {
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
		} else if(method.equals("edit")) {
			Edit(request, response);
		} else if(method.equals("modify")){
			Modify(request,response);
		} else if(method.equals("del")){
			Delete(request, response);
		}	
	}
	protected void Add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		 String groupname = request.getParameter("groupname");
		 String descriptor = request.getParameter("descriptor");
		 String authority = request.getParameter("authority");
		 String status = request.getParameter("state");
		 int state = 0;
		 if(status.equals("禁用")){
			 state = 1;
	}
		 Managroup managroup = new Managroup();
		 managroup.setGroupname(groupname);
		 managroup.setDescriptor(descriptor);
		 managroup.setAuthority(authority);
		 managroup.setState(state);
		 
		 GroupDao gd = new GroupDao();
		 
		 try{
			 gd.saveGroup(managroup);
			 
		 }catch(Exception e){
				e.printStackTrace();
			}
		 int group_id = 0;
		 try{
			 group_id = gd.getGroupId(groupname);
			 
		 }catch(Exception e){
				e.printStackTrace();
			}
		 String[] menus = request.getParameterValues("ID");
		 int[] menu_id = new int[menus.length];
		 for(int i=0;i<menus.length;i++){
			 menu_id[i]=Integer.parseInt(menus[i]);
			 
		 }
		 try{
			 gd.createGuanlian(group_id, menu_id);
			 
		 }catch(Exception e){
				e.printStackTrace();
			}
				
				
				
			RequestDispatcher rd = request.getRequestDispatcher("/Quanxian_set.jsp");
			rd.forward(request, response);
		 
		 
		
	}
	protected void Edit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("groupid");
		Managroup managroup = new Managroup();
		GroupDao gd = new GroupDao();		
		if(id == null){
			response.sendRedirect("Quanxian_set.jsp");
			return;
		}
		
		try{
			managroup = gd.getGroupById(id);
			request.setAttribute("managroup", managroup);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Quanxian_edit.jsp");
		rd.forward(request, response);
		
	}
	
	protected void Modify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

		 String groupname = request.getParameter("groupname");
		 String descriptor = request.getParameter("descriptor");
		 String authority = request.getParameter("authority");
		 String status = request.getParameter("state");
		 int group_id =Integer.parseInt(request.getParameter("groupid")); 
		 int state = 0;
		 if(status.equals("禁用")){
			 state = 1;
		 }

		 Managroup managroup = new Managroup();
		 managroup.setGroupname(groupname);
		 managroup.setDescriptor(descriptor);
		 managroup.setAuthority(authority);
		 managroup.setState(state);
		 managroup.setGroup_id(group_id);
		 
		 String[] menus = request.getParameterValues("ID");
		 int[] menu_id = new int[menus.length];
		 for(int i=0;i<menus.length;i++){
			 menu_id[i]=Integer.parseInt(menus[i]);
			 
		 }
		 
		 GroupDao gd = new GroupDao();
					
		try{
			gd.updateManagroup(managroup);
			gd.deleteGuanlianById(group_id);
			gd.createGuanlian(group_id, menu_id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Quanxian_set.jsp");
		rd.forward(request, response);
		
	}
	protected void Delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException { 
        				
		GroupDao gd = new GroupDao();		
		
		String id = request.getParameter("groupid");
		if(id == null){
			response.sendRedirect("Quanxian.jsp");
			return;
		}else{
		String[] idlist = request.getParameterValues("groupid");
		int[]  group_id=new int[idlist.length];
		for(int i =0;i<idlist.length;i++){
			group_id[i] = Integer.parseInt(idlist[i]);
		}
		try{
			gd.deleteGroup(group_id);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/User_gl.jsp");
		rd.forward(request, response);
		
		 
	}
	}
		

	
}
