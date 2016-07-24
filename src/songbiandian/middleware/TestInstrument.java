package songbiandian.middleware;

import java.io.File;
import java.util.List;

import songbiandian.xmlparse.*;

import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * <tt>TestInstrument</tt>类，用于找出试验仪器的信息
 * @author TerenceWu
 *
 */
public class TestInstrument {
	/**
	 * 调用<tt><i>getTargetElementText(Element rootElement, String equipmentName, String projectName)</i></tt>,
	 * 来获得试验设备的String
	 * @param equipmentName
	 * @param projectName
	 * @return String testInstrument
	 * @throws DocumentException
	 */
	public static String getTestInstrument(String equipmentName, String projectName) throws DocumentException {
		String testInstrument = "";
		Element rootElement = Xml.initializeXmlHandler(new File("D:\\程序设计文件夹\\JavaWeb\\workspace\\songbiandian\\WebRoot\\config\\standard.xml"));
		testInstrument = getTargetElementText(rootElement, equipmentName, projectName);
		return testInstrument;
	}
	
	/**
	 * 获取试验信息
	 * @param rootElement XML的根节点
	 * @param equipmentName 设备名称
	 * @param projectName 项目名称
	 * @return String targetElementText
	 */
	@SuppressWarnings("unchecked")
	private static String getTargetElementText(Element rootElement, String equipmentName, String projectName) {
		String targetElementText = "";
		List<Element> equipmentList = rootElement.elements();
		for (Element equipment : equipmentList) {
			if (equipment.attributeValue("name").equals(equipmentName)) {
				List<Element> projectList = equipment.elements();
				for (Element project : projectList) {
					if (project.attributeValue("name").equals(projectName)) {
						List<Element> childElementList = project.elements();
						for (Element child : childElementList) {
							if (child.getName().equals("testinstrument")) {
								targetElementText = child.getText();
							}
						}
					}
				}
			}
		}
		return targetElementText;
	}
}
