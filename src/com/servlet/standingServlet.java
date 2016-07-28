package com.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.StandingDao;
import com.entity.Standing;

public class standingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		  
		String bel_unit = request.getParameter("bel_unit");
		String erp_cord = request.getParameter("erp_cord");
		String sto_unit = request.getParameter("sto_unit");
		String custodian = request.getParameter("custodian");
		String equ_sort1 = request.getParameter("equ_sort1");
		String equ_sort2 = request.getParameter("equ_sort2");
		String equ_name = request.getParameter("equ_name");
		String equ_cord = request.getParameter("equ_cord");
		String equ_add = request.getParameter("equ_add");
		String item_number = request.getParameter("item_number");
		String standard = request.getParameter("standard");
		String equ_condition = request.getParameter("equ_condition");
		String equ_number = request.getParameter("equ_number");
		String measurement = request.getParameter("measurement");
		String manufacturer = request.getParameter("manufacturer");
		String date1 = request.getParameter("m_date");
		String date2 = request.getParameter("examine_date");
		String date3 = request.getParameter("maturity");
		String is_mature = request.getParameter("is_mature");		
		String remark = request.getParameter("remark");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date m_date = new Date();
		Date examine_date = new Date();
		Date maturity = new Date();
		try {		
			m_date = sdf.parse(date1);
			examine_date = sdf.parse(date2);
			maturity = sdf.parse(date3);
			
		} catch (ParseException e) {		
			e.printStackTrace();	
		}	
		
		Standing standing = new Standing();
		standing.setBel_unit(bel_unit);
		standing.setErp_cord(erp_cord);
		standing.setSto_unit(sto_unit);
		standing.setCustodian(custodian);
		standing.setEqu_sort1(equ_sort1);
		standing.setEqu_sort2(equ_sort2);
		standing.setEqu_name(equ_name);
		standing.setEqu_cord(equ_cord);
		standing.setEqu_add(equ_add);
		standing.setItem_number(item_number);
		standing.setStandard(standard);
		standing.setEqu_condition(equ_condition);
		standing.setEqu_number(equ_number);
		standing.setMeasurement(measurement);
		standing.setManufacturer(manufacturer);
		standing.setM_date(m_date);
		standing.setExamine_date(examine_date);
		standing.setMaturity(maturity);
		standing.setIs_mature(is_mature);
		standing.setRemark(remark);
		
		
		StandingDao sd = new StandingDao();		
		try{
			sd.saveStanding(standing);
		}catch(Exception e){
			e.printStackTrace();
		}
			
				
		RequestDispatcher rd = request.getRequestDispatcher("/Sbtz_new.jsp");
		rd.forward(request, response);
		
		 
	}
}

