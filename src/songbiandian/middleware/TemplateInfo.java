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
	
	private TemplateInfo(int templateId, String templateName, String equipmentType, String equipmentName, String templateAddedTime) {
		this.templateId = templateId;
		this.templateName = templateName;
		this.equipmentType = equipmentType;
		this.equipmentName = equipmentName;
		this.templateAddedTime = templateAddedTime;
	}
	
	public static TemplateInfo getInstanceOfTemplateInfo() {
		return new TemplateInfo();
	}
	
	public static TemplateInfo getInstanceOfTemplateInfo(int templateId, String templateName, String equipmentType, String equipmentName, String templateAddedTime) {
		return new TemplateInfo(templateId, templateName, equipmentType, equipmentName, templateAddedTime);
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
