package songbiandian.middleware;

import java.util.ArrayList;

/**
 * 这个类用于处理SQL语句的字符串
 * @author TerenceWu
 *
 */
public class SqlStringProcess {
	public static String generateFormatOne(ArrayList<String> paramList) {
		StringBuffer tempStringBuffer = new StringBuffer("(");
		for (String parameter : paramList) {
			tempStringBuffer.append(parameter);
			tempStringBuffer.append(",");
		}
		tempStringBuffer.append("test_report_name)");
		return tempStringBuffer.toString();
	}
	
	public static String generateFormatTwo(ArrayList<String> paramList) {
		StringBuffer tempStringBuffer = new StringBuffer("(");
		for (@SuppressWarnings("unused") String param : paramList) {
			tempStringBuffer.append("?");
			tempStringBuffer.append(",");
		}
		tempStringBuffer.append("?)");
		return tempStringBuffer.toString();
	}
	
	public static String deleteSpecificChar(String targetString, String charToBeDeleted) {
		String resultString = targetString.replaceAll(charToBeDeleted, "");
		return resultString;
	}
}
