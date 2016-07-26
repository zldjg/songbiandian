package songbiandian.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import songbiandian.middleware.SqlStringProcess;

import java.io.*;
import java.util.ArrayList;
public class Test extends HttpServlet {
	private static final long serialVersionUID = -6147392528598276392L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		String inputName = "35kv干式变_绝缘电阻_一次对二次及地";
		ArrayList<String> paramList = new ArrayList<>();
		paramList.add("R15s");
		paramList.add("R60s");
		paramList.add("R600s");
		paramList.add("R60s/R15s");
		paramList.add("R600s/R60s");
		String tempOneString = SqlStringProcess.generateFormatOne(paramList);
		String tempTwoString = SqlStringProcess.generateFormatTwo(paramList);
		String sqlString = "insert into " + inputName.toLowerCase() + tempOneString + " values" + tempTwoString;
		String[] projectStrings = request.getParameterValues(inputName);
		for (int i = 1 ; i <= paramList.size() ; i++) {
			System.out.println(sqlString+" :"+projectStrings[i-1]);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		doGet(request, response);
	}
}
