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
	/**
	 * 
	 */
	private static final long serialVersionUID = 2919564878872121775L;

	@SuppressWarnings("unchecked")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 数据库连接对象以及表头ReportTitle对象
		 */
		ReportTitle reportTitle = ReportTitle.getInstanceOfReportTitle();
		DBConn dbConn = DBConn.getInstanceOfDBConn();
		
		/**
		 * 取出session并且把session中的数据取出来
		 */
		HttpSession session = request.getSession();
		String equipmentName = (String)session.getAttribute("equipmentname");
		String[] projects = (String[])session.getAttribute("projectstring");
		HashMap<String, ArrayList<String>> positionListMap = (HashMap<String, ArrayList<String>>)session.getAttribute("positionofprojectmap");
		HashMap<String, ArrayList<String>> paramListMap = (HashMap<String, ArrayList<String>>)session.getAttribute("paramofpositionmap");
		HashMap<String, String> standardMap = (HashMap<String, String>)session.getAttribute("standardMap");
		HashMap<String, String> testInstrumentMap = (HashMap<String, String>)session.getAttribute("testinstrumentMap");
		HashMap<String, ArrayList<String>> paramOfFirstLineMap = (HashMap<String, ArrayList<String>>)session.getAttribute("paramoffirstlinemap");
		HashMap<String, HashMap<String, ArrayList<String>>> paramOfProjectMap = (HashMap<String, HashMap<String, ArrayList<String>>>)session.getAttribute("paramofprojectmap");
		HashMap<String, ArrayList<String>> paramOfNoPositionMap = (HashMap<String, ArrayList<String>>)session.getAttribute("paramofnoposition");
		
		/**
		 * 处理表格主体的部分
		 */
		for (int i = 0 ; i < projects.length ; i++) {
			ArrayList<String> positionListOfProject = positionListMap.get(projects[i]);
			if (positionListOfProject == null) {
				
			}
			else {
				
			}
		}
		
		/**
		 * 处理表头的部分
		 */
		String testUnit = request.getParameter("test_unit");
		
		response.sendRedirect("Sybg_gl.jsp");
	}
	
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
