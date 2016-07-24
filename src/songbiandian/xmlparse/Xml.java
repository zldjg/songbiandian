package songbiandian.xmlparse;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 处理XML
 * @author TerenceWu
 *
 */
public class Xml {
	/**
	 * 一个XML初始化处理器,根据指定的XML文件路径返回XML文件的根节点
	 * @param xmlFilePath 待处理的XML文件路径
	 * @return Element <tt><i>rootElement</i></tt>
	 * @throws DocumentException
	 */
	public static Element initializeXmlHandler(File xmlFilePath) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(xmlFilePath);
		return document.getRootElement();
	}
}
