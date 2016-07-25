package songbiandian.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import songbiandian.jdbc.*;
import songbiandian.javabean.*;

/**
 * <tt>SavaTestReport</tt>用于存储试验报告的内容
 * @author TerenceWu
 *
 */
public class SaveTestReport extends HttpServlet {
	private static final long serialVersionUID = 2919564878872121775L;

	@SuppressWarnings("unchecked")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 数据库连接对象以及表头ReportTitle对象
		 */
		//ReportTitle reportTitle = ReportTitle.getInstanceOfReportTitle();
		DBConn dbConn = DBConn.getInstanceOfDBConn();
		
		/**
		 * 取出session并且把session中的数据取出来
		 */
		HttpSession session = request.getSession();
		String equipmentName = (String)session.getAttribute("test_equipmentname");
		List<String> projectsList = (List<String>)session.getAttribute("test_projectslist");
		HashMap<String, ArrayList<String>> positionListMap = (HashMap<String, ArrayList<String>>)session.getAttribute("test_positionofprojectmap");
		HashMap<String, ArrayList<String>> paramListMap = (HashMap<String, ArrayList<String>>)session.getAttribute("test_paramofpositionmap");
		HashMap<String, String> standardMap = (HashMap<String, String>)session.getAttribute("test_standardMap");
		HashMap<String, String> testInstrumentMap = (HashMap<String, String>)session.getAttribute("test_testinstrumentMap");
		HashMap<String, ArrayList<String>> paramOfFirstLineMap = (HashMap<String, ArrayList<String>>)session.getAttribute("test_paramoffirstlinemap");
		HashMap<String, HashMap<String, ArrayList<String>>> paramOfProjectMap = (HashMap<String, HashMap<String, ArrayList<String>>>)session.getAttribute("test_paramofprojectmap");
		HashMap<String, ArrayList<String>> paramOfNoPositionMap = (HashMap<String, ArrayList<String>>)session.getAttribute("test_paramofnoposition");
		
		/**
		 * 处理表格主体的部分
		 */
		for (String project : projectsList) {
			HashMap<String, ArrayList<String>> paramOfSingleProjectMap = paramOfProjectMap.get(project);
	 		ArrayList<String> positionListOfProject = positionListMap.get(project);
	 		if (positionListOfProject == null) {
	 			ArrayList<String> paramOfNoPosition = paramOfNoPositionMap.get(project);
	 			if (paramOfNoPosition.size() == 1) {
	 				
	 			}
	 			else {
	 				for (String param : paramOfNoPosition) {

	 				}
	 			}
	 		}
	 		else {
	 			ArrayList<String> paramOfFirstLineList = paramOfFirstLineMap.get(project);
	 			if (paramOfFirstLineList != null) {
	 				if (paramOfFirstLineList.size() == 1) {
	 					
	 				}
	 				else {
	 					for (String param : paramOfFirstLineList) {
	 						
	 					}
	 				}
	 			}
	 			for (String position : positionListOfProject) {		
	 				HashMap<String, ArrayList<String>> paramOfThisPositionMap = paramOfProjectMap.get(project);
	 				ArrayList<String> paramOfThisPositionList = paramOfThisPositionMap.get(position);
	 				if (paramOfThisPositionList != null) {
	 					if (paramOfThisPositionList.size() == paramOfFirstLineList.size()) {
	 					   	for (int j = 0 ; j < paramOfThisPositionList.size() ; j++) {
	 					   		
	 					   	}
	 					}
	 					else {
	 					   	if (paramOfThisPositionList.size() == 1) {

	 					   	}
	 					   	else {
	 					   		for (String parameter : paramOfThisPositionList) {
	 					   			
	 					   		}
	 					   	}
	 					}

	 				}
	 			}
	 		}
	 	}
		
		/**
		 * 处理表头的部分
		 */
		//String testUnit = request.getParameter("test_unit");
		
		response.sendRedirect("Sybg_gl.jsp");
	}
	
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
