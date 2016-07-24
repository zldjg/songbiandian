package songbiandian.middleware;

public class TemplateInfo {
	private int templateId;
	private String templateName;
	private String equipmentType;
	private String equipmentName;
	private String templateAddedTime;
	
	private TemplateInfo() {
		super();
	}
	
	public static TemplateInfo getInstanceOfTemplateInfo() {
		return new TemplateInfo();
	}
	
	public int getTemplateId() {
		return templateId;
	}
	
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	
	public String getTemplateName() {
			return templateName;
	}
	
	public void setTemplateName(String templateName) {
			this.templateName = templateName;
	}
	
	public String getEquipmentType() {
			return equipmentType;
	}
	
	public void setEquipmentType(String equipmentType) {
			this.equipmentType = equipmentType;

	}
	
	public String getEquipmentName() {
			return equipmentName;
	}
	
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	
	public String getTemplateAddedTime() {
			return templateAddedTime;
	}
	
	public void setTemplateAddedTime(String addedTime) {
		this.templateAddedTime = addedTime;
	}
}
