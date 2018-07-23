package cn.lanqiao.model;


public class TbStudent {
	private int studentNum;
	private String studentName;
	private String studentSex;
	private String  studentBirthday;
	private int classId;

	public TbStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TbStudent(int studentNum, String studentName, String studentSex, String studentBirthday, int classId) {
		super();
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.studentSex = studentSex;
		this.studentBirthday = studentBirthday;
		this.classId = classId;
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSex() {
		return studentSex;
	}
	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}
	public String getStudentBirthday() {
		return studentBirthday;
	}
	public void setStudentBirthday(String studentBirthday) {
		this.studentBirthday = studentBirthday;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	@Override
	public String toString() {
		return "TbStudent [studentNum=" + studentNum + ", studentName=" + studentName + ", studentSex=" + studentSex
				+ ", studentBirthday=" + studentBirthday + ", classId=" + classId + "]";
	}
	
}
