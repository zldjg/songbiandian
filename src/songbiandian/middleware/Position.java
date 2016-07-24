package songbiandian.middleware;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;

import songbiandian.xmlparse.Xml;

/**
 * <tt>Position</tt>类用于获取指定<tt><i>equipment</i></tt>和<tt><i>project</i></tt>对应的位置信息
 * @author TerenceWu
 *
 */
public class Position {
	/**
	 * 根据指定的<tt><i>equipmentName</i></tt>以及<tt><i>projectName</i></tt>查找出对应的位置,<br>
	 * 并且把位置信息放置在<tt><i>ArrayList</i></tt>中
	 * @param equipmentName 设备名称
	 * @param projectName 试验项目名称
	 * @return ArrayList positions
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getPositions(String equipmentName, String projectName) throws DocumentException {
		/**
		 * positions存储equipmentName和projectName对应的位置
		 */
		ArrayList<String> positions = new ArrayList<>();
		Element rootElement = Xml.initializeXmlHandler(new File("D:\\程序设计文件夹\\JavaWeb\\workspace\\songbiandian\\WebRoot\\config\\config.xml"));
		List<Element> equipmentList = rootElement.elements();
		for (Element equipment : equipmentList) {
			if (equipment.attributeValue("name").equals(equipmentName)) {
				List<Element> projectList = equipment.elements();
				for (Element project : projectList) {
					if (project.attributeValue("name").equals(projectName)) {
						List<Element> positionList = project.elements();
						for (Element position : positionList) {
							if (position.getName().equals("position")) {
								positions.add(position.attributeValue("name"));
							}
							else {
								positions = null;
							}
						}
					}
				}
			}
		}
		return positions;
	}
	
	/**
	 * 根据指定的<tt><i>equipmentName</i></tt>以及<tt><i>projectName</i></tt>查找出对应的位置元素,<br>
	 * 并且把位置信息放置在<tt><i>List</i></tt>中
	 * @param equipmentName 设备名称
	 * @param projectName 试验项目名称
	 * @return List positionList
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static List<Element> getPositionList(String equipmentName, String projectName) throws DocumentException {
		/**
		 * positions存储equipmentName和projectName对应的位置
		 */
		List<Element> positionList = null;
		Element rootElement = Xml.initializeXmlHandler(new File("D:\\程序设计文件夹\\JavaWeb\\workspace\\songbiandian\\WebRoot\\config\\config.xml"));
		List<Element> equipmentList = rootElement.elements();
		for (Element equipment : equipmentList) {
			if (equipment.attributeValue("name").equals(equipmentName)) {
				List<Element> projectList = equipment.elements();
				for (Element project : projectList) {
					if (project.attributeValue("name").equals(projectName)) {
						positionList = project.elements();
						return positionList;
						}
					}
				}
			}
		return positionList;
	}
}
