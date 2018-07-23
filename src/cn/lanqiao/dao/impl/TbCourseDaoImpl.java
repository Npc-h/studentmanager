package cn.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.lanqiao.dao.TbCourseDao;
import cn.lanqiao.model.TbCourse;
import cn.lanqiao.util.JdbcUtil;

public class TbCourseDaoImpl implements TbCourseDao {

	@Override
	public List<TbCourse> list() {
		List <TbCourse> tcs =new ArrayList<TbCourse>();
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//1.获取连接
			conn =JdbcUtil.getConnection();
			//2.创建Statement
			st=conn.createStatement();
			//3.执行查询
			String sql="select * from Tb_Course";
			rs= st.executeQuery(sql);
			TbCourse tbccourse=null;
			while (rs.next()){
				int courseNum = rs.getInt("COURSE_NUM");
				String courseName = rs.getString("COURSE_NAME");
				int courseHour = rs.getInt("COURSE_HOUR");
				String courseScore = rs.getString("COURSE_SCORE");
				tbccourse = new TbCourse(courseNum, courseName, courseHour, courseScore);
				tcs.add(tbccourse);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, st, rs);
		}
		return tcs;
	}

	@Override
	public void insert(TbCourse tbcourse) {
		Connection conn =null;
		PreparedStatement ps =null;
		try {
			conn=JdbcUtil.getConnection();
			String sql="insert into Tb_Course values (?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, tbcourse.getCourseNum());
			ps.setString(2,tbcourse.getCourseName());
			ps.setInt(3, tbcourse.getCourseHour());
			ps.setString(4, tbcourse.getCourseScore());
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, null);
		}

	}

	@Override
	public void remove(TbCourse tbcourse) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql ="delete from Tb_Course where COURSE_NUM=?";
			ps = conn.prepareStatement(sql);
			//ORMapping;
			ps.setInt(1,tbcourse.getCourseNum()); 
			ps.executeQuery();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			JdbcUtil.close(conn, ps, null);
		}

	}

	@Override
	public void update(TbCourse tbcourse) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql ="update Tb_Course set COURSE_NUM=?,COURSE_NAME=?,COURSE_HOUR=?,COURSE_SCORE=? where COURSE_NUM=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,tbcourse.getCourseNum());
			ps.setString(2, tbcourse.getCourseName());
			ps.setInt(3, tbcourse.getCourseHour());
			ps.setString(4, tbcourse.getCourseScore());
			ps.setInt(5,tbcourse.getCourseNum());
			ps.executeQuery();	
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			JdbcUtil.close(conn, ps, null);
		}
	}

}
