package com.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.SignatureDao;
import com.entity.Signature;

public class signatureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		  
		String sig_name = request.getParameter("sig_name");
		String sig_content = request.getParameter("sig_content");
		String creation_date = request.getParameter("creation_date");
		String creator = request.getParameter("creator");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		try {		
			date = sdf.parse(creation_date);	
		} catch (ParseException e) {		
			e.printStackTrace();	
		}	
		
		
		Signature signature = new Signature();
		signature.setSig_name(sig_name);
		signature.setSig_content(sig_content);
		signature.setCreation_date(date);
		signature.setCreator(creator);
			
				
		SignatureDao sd = new SignatureDao();
		try{
			sd.saveSignature(signature);;
		}catch(Exception e){
			e.printStackTrace();
		}
			
				
		RequestDispatcher rd = request.getRequestDispatcher("/Dzqz_new.jsp");
		rd.forward(request, response);
		
		 
	}
}
