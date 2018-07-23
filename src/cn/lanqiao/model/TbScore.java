package cn.lanqiao.model;

public class TbScore {
	private int scoreId;
	private int scoreGrade;
	private int studentNum;
	private int courseNum;
	
	public TbScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TbScore(int scoreId, int scoreGrade, int studentNum, int courseNum) {
		super();
		this.scoreId = scoreId;
		this.scoreGrade = scoreGrade;
		this.studentNum = studentNum;
		this.courseNum = courseNum;
	}
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	public int getScoreGrade() {
		return scoreGrade;
	}
	public void setScoreGrade(int scoreGrade) {
		this.scoreGrade = scoreGrade;
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public int getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	@Override
	public String toString() {
		return "TbScore [scoreId=" + scoreId + ", scoreGrade=" + scoreGrade + ", studentNum=" + studentNum
				+ ", courseNum=" + courseNum + "]";
	}
}
