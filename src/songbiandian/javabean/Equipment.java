package songbiandian.javabean;

public class Equipment {
	private Integer equipmentId;
	private String equipmentName;
	
	public Equipment() {
		equipmentId = 0;
		equipmentName = null;
	}
	
	public Integer getEquipmentId() {
		return equipmentId;
	}
	
	public String getEquipmentName() {
		return equipmentName;
	}
	
	public void setEquipmentId(Integer equipmentid) {
		equipmentId = equipmentid;
	}
	
	public void setEquipmentName(String equipmentname) {
		equipmentName = equipmentname;
	}
}
