package cn.lanqiao.model;

public class UserMnager {
	private int idUser;
	private String userName;
	private String userPwd;
	private int userType;
	
	public UserMnager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserMnager(int idUser, String userName, String userPwd, int userType) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "UserMnager [idUser=" + idUser + ", userName=" + userName + ", userPwd=" + userPwd + ", userType="
				+ userType + "]";
	}
}
