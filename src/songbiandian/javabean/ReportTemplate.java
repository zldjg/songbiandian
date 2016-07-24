package songbiandian.javabean;

/**
 * <tt>ReportTemplate</tt>,试验报告模板的JavaBean
 * @author TerenceWu
 *
 */
public class ReportTemplate {
	/**
	 * 试验报告模板的id
	 */
	private int reportTemplateId;
	/**
	 * 试验报告模板的名称
	 */
	private String reportTemplateName;
	
	/**
	 * 私有的构造器方法
	 */
	private ReportTemplate() {
		reportTemplateId = 0;
		reportTemplateName = "";
	}
	
	/**
	 * 静态的工厂方法,用于创建对象
	 * @return new ReportTemplate()
	 */
	public static ReportTemplate getInstanceOfReportTemplate() {
		return new ReportTemplate();
	}
	
	public int getReportTemplateId() {
		return reportTemplateId;
	}
	
	public String getReportTemplateName() {
		return reportTemplateName;
	}
	
	public void setReportTemplateId(int targetId) {
		reportTemplateId = targetId;
	}
	
	public void setReportTemplateName(String targetName) {
		reportTemplateName = targetName;
	}
}
