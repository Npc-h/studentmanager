package cn.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.lanqiao.dao.TbStudentDao;
import cn.lanqiao.model.TbStudent;
import cn.lanqiao.model.UserMnager;
import cn.lanqiao.util.JdbcUtil;

public class TbStudentDaoImpl implements TbStudentDao {

	@Override
	public List<TbStudent> list() {
		List <TbStudent> tst =new ArrayList<TbStudent>();
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//1.获取连接
			conn =JdbcUtil.getConnection();
			//2.创建Statement
			st=conn.createStatement();
			//3.执行查询
			String sql="select * from Tb_Student";
			rs= st.executeQuery(sql);
			TbStudent tbstudent=null;
			while (rs.next()){
			    int studentNum = rs.getInt("STUDENT_NUM");
			    String studentName = rs.getString("STUDENT_NAME");
			    String studentSex = rs.getString("STUDENT_SEX");
			    String studentBirthday = rs.getString("STUDENT_BIRTHDAY");
			    int classId = rs.getInt("CLASS_ID");
				tbstudent = new TbStudent(studentNum, studentName, studentSex, studentBirthday, classId);
				tst.add(tbstudent);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, st, rs);
		}
		return tst;
		/*List<TbStudent> datas = null;
		try {
			QueryRunner queryRunner = new QueryRunner();
			datas = queryRunner.query(JdbcUtil.getConnection(), "select * from Tb_Student",new BeanListHandler<>(TbStudent.class));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return datas;*/
	}

	@Override
	public void insert(TbStudent tbstudent) {
		Connection conn =null;
		PreparedStatement ps =null;
		try {
			conn=JdbcUtil.getConnection();
			String sql="insert into Tb_Student values (?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,tbstudent.getStudentNum());
			ps.setString(2, tbstudent.getStudentName());
			ps.setString(3, tbstudent.getStudentSex());
			ps.setString(4, tbstudent.getStudentBirthday());
			ps.setInt(5,tbstudent.getClassId());
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, null);
		}

	}

	@Override
	public void remove(TbStudent tbstudent) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql ="delete from Tb_Student where STUDENT_NUM=?";
			ps = conn.prepareStatement(sql);
			//ORMapping;
			ps.setInt(1,tbstudent.getStudentNum()); 
			ps.executeQuery();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			JdbcUtil.close(conn, ps, null);
		}

	}

	@Override
	public void update(TbStudent tbstudent) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql ="update Tb_Student set STUDENT_NUM=?,STUDENT_NAME=?,STUDENT_SEX=?,STUDENT_BIRTHDAY=?,CLASS_ID=? where STUDENT_NUM=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,tbstudent.getStudentNum());
			ps.setString(2, tbstudent.getStudentName());
			ps.setString(3, tbstudent.getStudentSex());
			ps.setString(4, tbstudent.getStudentBirthday());
			ps.setInt(5,tbstudent.getClassId());
			ps.setInt(6,tbstudent.getStudentNum());
			ps.executeQuery();	
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			JdbcUtil.close(conn, ps, null);
		}
	}

	@Override
	public List<TbStudent> vaguaSearch(String name) {
		List <TbStudent> tst =new ArrayList<TbStudent>();
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//1.获取连接
			conn =JdbcUtil.getConnection();
			//2.创建Statement
			st=conn.createStatement();
			//3.执行查询
			String sql="select * from Tb_Student where Student_Name like"+" '"+"%"+name+"%'";
			rs= st.executeQuery(sql);
			TbStudent tbstudent=null;
			while (rs.next()){
			    int studentNum = rs.getInt("STUDENT_NUM");
			    String studentName = rs.getString("STUDENT_NAME");
			    String studentSex = rs.getString("STUDENT_SEX");
			    String studentBirthday = rs.getString("STUDENT_BIRTHDAY");
			    int classId = rs.getInt("CLASS_ID");
				tbstudent = new TbStudent(studentNum, studentName, studentSex, studentBirthday, classId);
				tst.add(tbstudent);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, st, rs);
		}
		return tst;

	
	}
	
}
