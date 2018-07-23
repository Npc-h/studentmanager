package cn.lanqiao.model;

public class TbCourse {
	 private int courseNum;
	 private String courseName;
	 private int courseHour;
	 private String courseScore;
	 
	public TbCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TbCourse(int courseNum, String courseName, int courseHour, String courseScore) {
		super();
		this.courseNum = courseNum;
		this.courseName = courseName;
		this.courseHour = courseHour;
		this.courseScore = courseScore;
	}
	public int getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseHour() {
		return courseHour;
	}
	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}
	public String getCourseScore() {
		return courseScore;
	}
	public void setCourseScore(String courseScore) {
		this.courseScore = courseScore;
	}
	@Override
	public String toString() {
		return "TbCourse [courseNum=" + courseNum + ", courseName=" + courseName + ", courseHour=" + courseHour
				+ ", courseScore=" + courseScore + "]";
	}
	 
}
