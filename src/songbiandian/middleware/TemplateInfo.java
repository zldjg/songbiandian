package songbiandian.middleware;

public class TemplateInfo {
	private int templateId;
	private String templateName;
	private String equipmentType;
	private String equipmentName;
	
	private TemplateInfo() {
		super();
	}
	
	public static TemplateInfo getInstanceOfTemplateInfo() {
		return new TemplateInfo();
	}
	
	public synchronized int getTemplateId() {
		return templateId;
	}
	
	public synchronized void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	
	public String getTemplateName() {
		synchronized (equipmentName) {
			return templateName;
		}
	}
	
	public void setTemplateName(String templateName) {
		synchronized (this.templateName) {
			this.templateName = templateName;
		}
	}
	
	public String getEquipmentType() {
		synchronized (equipmentType) {
			return equipmentType;
		}
	}
	
	public void setEquipmentType(String equipmentType) {
		synchronized (this.equipmentType) {
			this.equipmentType = equipmentType;
		}
	}
	
	public String getEquipmentName() {
		synchronized (equipmentName) {
			return equipmentName;
		}
	}
	
	public void setEquipmentName(String equipmentName) {
		synchronized (this.equipmentName) {
			this.equipmentName = equipmentName;
		}
	}
}
