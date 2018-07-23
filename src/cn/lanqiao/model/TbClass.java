package cn.lanqiao.model;

public class TbClass {
	private  int classId;
	private String className;
	
	public TbClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TbClass(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "TbClass [classId=" + classId + ", className=" + className + "]";
	}
}
