package songbiandian.middleware;

import java.io.File;
import java.util.List;

import songbiandian.xmlparse.*;

import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * <tt>Standard</tt>类,类中用于存放查找试验项目标准的静态方法
 * @author TerenceWu
 *
 */
public class Standard {
	/**
	 * 根据指定的<tt><i>equipmentName</i></tt>和<tt><i>projectName</i></tt>查找出对应的标准值
	 * @param equipmentName 设备名称
	 * @param projectName 试验项目名称
	 * @return String standard
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static String getStandard(String equipmentName, String projectName) throws DocumentException {
		String standard = "";
		Element rootElement = Xml.initializeXmlHandler(new File("D:\\程序设计文件夹\\JavaWeb\\workspace\\songbiandian\\WebRoot\\config\\standard.xml"));
		List<Element> equipmentList = rootElement.elements();
		for (Element equipment : equipmentList) {
			if (equipment.attributeValue("name").equals(equipmentName)) {
				List<Element> projectList = equipment.elements();
				for (Element project : projectList) {
					if (project.attributeValue("name").equals(projectName)) {
						List<Element> childElementList = project.elements();
						for (Element child : childElementList) {
							if (child.getName().equals("standard")) {
								standard = child.getText();
							}
						}
					}
				}
			}
		}
		return standard;
	}
}
