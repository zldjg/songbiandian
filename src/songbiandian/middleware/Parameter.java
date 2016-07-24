package songbiandian.middleware;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;

import songbiandian.xmlparse.Xml;

/**
 * <tt>Parameter</tt>类用于获取特定<tt><i>equipment</i></tt>、<tt><i>project</i></tt>以及<tt><i>position</i></tt>对应的参数信息
 * @author TerenceWu
 *
 */
public class Parameter {
	/**
	 * 对于特定的设备<tt><i>equipmentName</i></tt>、试验项目<tt><i>projectName</i></tt>、位置信息<tt><i>positionName</i></tt>,<br>
	 * 找出该位置对应的所有参数,参数信息储存在<tt><i>ArrayList</i></tt>中
	 * @param equipmentName
	 * @param projectName
	 * @param positionName
	 * @return ArrayList parameters
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getParameters(String equipmentName, String projectName, String positionName) throws DocumentException {
		ArrayList<String> parameters = new ArrayList<>();
		List<Element> positionList = Position.getPositionList(equipmentName, projectName);
		/**
		 * 有一些试验项目没有位置信息
		 */
		if (positionList == null) {
			Element rootElement = Xml.initializeXmlHandler(new File("D:\\程序设计文件夹\\JavaWeb\\workspace\\songbiandian\\WebRoot\\config\\config.xml"));
			List<Element> equipmentList = rootElement.elements();
			for (Element equipment : equipmentList) {
				if (equipment.attributeValue("name").equals(equipmentName)) {
					List<Element> projectList = equipment.elements();
					for (Element project : projectList) {
						if (project.attributeValue("name").equals(projectName)) {
							List<Element> parameterList = project.elements();
							for (Element parameter : parameterList) {
								parameters.add(parameter.getText());
							}
						}
					}
				}
			}
		}
		else {
			for (Element position : positionList) {
				if (position.attributeValue("name").equals(positionName)) {
					List<Element> parameterList = position.elements();
					for (Element parameter : parameterList) {
						parameters.add(parameter.getText());
					}
				}
			}
		}
		return parameters;
	}
	
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getParamOfNoPosition(String equipmentName, String projectName) throws DocumentException {
		ArrayList<String> paramsList = new ArrayList<>();
		Element rootElement = Xml.initializeXmlHandler(new File("D:\\程序设计文件夹\\JavaWeb\\workspace\\songbiandian\\WebRoot\\config\\config.xml"));
		List<Element> equipmentList = rootElement.elements();
		for (Element equipment : equipmentList) {
			if (equipment.attributeValue("name").equals(equipmentName)) {
				List<Element> projectList = equipment.elements();
				for (Element project : projectList) {
					if (project.attributeValue("name").equals(projectName)) {
						List<Element> paramElements = project.elements();
						for (Element param : paramElements) {
							paramsList.add(param.getText());
						}
					}
				}
			}
		}
		return paramsList;
	}
}
