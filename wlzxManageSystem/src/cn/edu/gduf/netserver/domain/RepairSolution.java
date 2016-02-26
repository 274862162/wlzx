package cn.edu.gduf.netserver.domain;

public class RepairSolution {
	private String id;
	private String type;
	private String codeName;
	private String codeDescript;
	private String solution;
	
	public String getCodeDescript() {
		return codeDescript;
	}
	public void setCodeDescript(String codeDescript) {
		this.codeDescript = codeDescript;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	
}
