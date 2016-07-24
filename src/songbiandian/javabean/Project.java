package songbiandian.javabean;

/**
 * 对应项目的JavaBean
 * @author TerenceWu
 *
 */
public class Project {
	private Integer projectId;
	private String projectName;
	
	public Project(Integer projectid, String projectname) {
		projectId = projectid;
		projectName = projectname;
	}
	
	public Integer getProjectId() {
		return projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectId(Integer targetId) {
		projectId = targetId;
	}
	
	public void setProjectName(String targetName) {
		projectName = targetName;
	}
}
