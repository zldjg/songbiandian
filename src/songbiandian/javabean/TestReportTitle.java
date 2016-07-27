package songbiandian.javabean;

public class TestReportTitle {
	public int test_report_ID;
	public String test_report_name;
	public String station_name;
	public String equipment_type;
	public String test_attribute;
	public String test_person;
	public String test_date;
	public String report_date;
	public String test_unit;
	public String report_person;
	public String test_approver;
	public String test_location;
	public String assessor;
	public String test_model;
	public String runtime_serialnumber;
	public String rated_voltage;
	public String rated_current;
	public String rated_capacity;
	public String connection_group;
	public String manufacture_name;
	public String manufacture_date;
	public String install_location;
	public String manufacture_number;
	public String addedTime;
	public String test_report_template_name;
	public String weather;
	public String temperature;
	public String humidity;
	
	private TestReportTitle() {
		super();
	}
	
	public static TestReportTitle getInstanceOfTestReportTitle() {
		return new TestReportTitle();
	}
	
	/**
	 * 
	 * @param test_report_ID
	 * @param test_report_name
	 * @param station_name
	 * @param equipment_type
	 * @param test_attribute
	 * @param test_person
	 * @param test_date
	 * @param report_date
	 * @param test_unit
	 * @param report_person
	 * @param test_approver
	 * @param test_location
	 * @param assessor
	 * @param test_model
	 * @param runtime_serialnumber
	 * @param rated_voltage
	 * @param rated_current
	 * @param rated_capacity
	 * @param connection_group
	 * @param manufacture_name
	 * @param manufacture_date
	 * @param install_location
	 * @param manufacture_number
	 * @param addedTime
	 * @param test_report_template_name
	 */
	private TestReportTitle(int test_report_ID, String test_report_name, String station_name, String equipment_type, String test_attribute, String test_person, String test_date, String report_date, String test_unit, String report_person, String test_approver, String test_location, String assessor, String test_model, String runtime_serialnumber, String rated_voltage, String rated_current, String rated_capacity, String connection_group, String manufacture_name, String manufacture_date, String install_location, String manufacture_number, String addedTime, String test_report_template_name) {
		this.test_report_ID = test_report_ID;
		this.test_report_name = test_report_name;
		this.station_name  = station_name;
		this.equipment_type = equipment_type;
		this.test_attribute = test_attribute;
		this.test_person = test_person;
		this.test_date = test_date;
		this.report_date = report_date;
		this.test_unit = test_unit;
		this.report_person = report_person;
		this.test_approver = test_approver;
		this.test_location = test_location;
		this.assessor = assessor;
		this.test_model = test_model;
		this.runtime_serialnumber = runtime_serialnumber;
		this.rated_voltage = rated_voltage;
		this.rated_current = rated_current;
		this.rated_capacity = rated_capacity;
		this.connection_group = connection_group;
		this.manufacture_name = manufacture_name;
		this.manufacture_date = manufacture_date;
		this.install_location = install_location;
		this.manufacture_number = manufacture_number;
		this.addedTime = addedTime;
		this.test_report_template_name = test_report_template_name;
	}
	
	/**
	 * 
	 * @param test_report_ID
	 * @param test_report_name
	 * @param station_name
	 * @param equipment_type
	 * @param test_attribute
	 * @param test_person
	 * @param test_date
	 * @param report_date
	 * @param test_unit
	 * @param report_person
	 * @param test_approver
	 * @param test_location
	 * @param assessor
	 * @param test_model
	 * @param runtime_serialnumber
	 * @param rated_voltage
	 * @param rated_current
	 * @param rated_capacity
	 * @param connection_group
	 * @param manufacture_name
	 * @param manufacture_date
	 * @param install_location
	 * @param manufacture_number
	 * @param addedTime
	 * @param test_report_template_name
	 * @return
	 */
	public static TestReportTitle getInstanceOfTestReportTitle(int test_report_ID, String test_report_name, String station_name, String equipment_type, String test_attribute, String test_person, String test_date, String report_date, String test_unit, String report_person, String test_approver, String test_location, String assessor, String test_model, String runtime_serialnumber, String rated_voltage, String rated_current, String rated_capacity, String connection_group, String manufacture_name, String manufacture_date, String install_location, String manufacture_number, String addedTime, String test_report_template_name) {
		return new TestReportTitle(test_report_ID, test_report_name, station_name, equipment_type, test_attribute, test_person, test_date, report_date, test_unit, report_person, test_approver, test_location, assessor, test_model, runtime_serialnumber, rated_voltage, rated_current, rated_capacity, connection_group, manufacture_name, manufacture_date, install_location, manufacture_number, addedTime, test_report_template_name);
	}
}
