package songbiandian.javabean;

public class TestReportMetaData {
	/**
	 * 试验报告ID
	 */
	private int testReportId;
	/**
	 * 试验报告名称
	 */
	private String testReportName;
	/**
	 * 所属站房名称
	 */
	private String stationName;
	/**
	 * 设备类型
	 */
	private String equipmentType;
	/**
	 * 试验性质
	 */
	private String testAttribute;
	/**
	 * 试验人员
	 */
	private String testPerson;
	/**
	 * 试验日期
	 */
	private String testDate;
	/**
	 * 报告日期
	 */
	private String reportDate;
	
	private TestReportMetaData(int id, String reportName, String stationName, String equipmentType, String testAttribute, String testPerson, String testDate, String reportDate) {
		this.testReportId = id;
		this.testReportName = reportName;
		this.stationName = stationName;
		this.equipmentType = equipmentType;
		this.testAttribute = testAttribute;
		this.testPerson = testPerson;
		this.testDate = testDate;
		this.reportDate = reportDate;
	}
	
	public static TestReportMetaData getInstanceOfTestReportMetaData(int id, String reportName, String stationName, String equipmentType, String testAttribute, String testPerson, String testDate, String reportDate) {
		return new TestReportMetaData(id, reportName, stationName, equipmentType, testAttribute, testPerson, testDate, reportDate);
	}
	
	public int getTestReportId() {
		return testReportId;
	}
	
	public String getTestReportName() {
		return testReportName;
	}
	
	public String getStationName() {
		return stationName;
	}
	
	public String getEquipmentType() {
		return equipmentType;
	}
	
	public String getTestAttribute() {
		return testAttribute;
	}
	
	public String getTestPerson() {
		return testPerson;
	}
	
	public String getTestDate() {
		return testDate;
	}
	
	public String getReportDate() {
		return reportDate;
	}
}
