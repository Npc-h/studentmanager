package cn.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.lanqiao.dao.TbScoreDao;
import cn.lanqiao.model.TbScore;
import cn.lanqiao.util.JdbcUtil;

public class TbScoreDaoImpl implements TbScoreDao {

	@Override
	public List<TbScore> list() {
		List <TbScore> ts =new ArrayList<TbScore>();
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//1.获取连接
			conn =JdbcUtil.getConnection();
			//2.创建Statement
			st=conn.createStatement();
			//3.执行查询
			String sql="select * from Tb_Score";
			rs= st.executeQuery(sql);
			TbScore tbscore=null;
			while (rs.next()){
				int scoreId = rs.getInt("SCORE_ID");
				int scoreGrade = rs.getInt("SCORE_GRADE");
				int studentNum = rs.getInt("STUDENT_NUM");
				int courseNum = rs.getInt("COURSE_NUM");
				tbscore = new TbScore(scoreId, scoreGrade, studentNum, courseNum);
				ts.add(tbscore);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, st, rs);
		}
		return ts;
	}

	@Override
	public void insert(TbScore tbscore) {
		Connection conn =null;
		PreparedStatement ps =null;
		try {
			conn=JdbcUtil.getConnection();
			String sql="insert into Tb_Score values (?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,tbscore.getScoreId());
			ps.setInt(2,tbscore.getScoreGrade());
			ps.setInt(3,tbscore.getStudentNum());
			ps.setInt(4,tbscore.getCourseNum());
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, null);
		}

	}

	@Override
	public void remove(TbScore tbscore) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql ="delete from Tb_Score where SCORE_ID=?";
			ps = conn.prepareStatement(sql);
			//ORMapping;
			ps.setInt(1,tbscore.getScoreId()); 
			ps.executeQuery();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			JdbcUtil.close(conn, ps, null);
		}

	}

	@Override
	public void update(TbScore tbscore) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql ="update Tb_Score set SCORE_ID=?,SCORE_GRADE=?,STUDENT_NUM=?,COURSE_NUM=? where SCORE_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,tbscore.getScoreId());
			ps.setInt(2,tbscore.getScoreGrade());
			ps.setInt(3,tbscore.getStudentNum());
			ps.setInt(4,tbscore.getCourseNum());
			ps.setInt(5,tbscore.getScoreId());
			ps.executeQuery();	
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			JdbcUtil.close(conn, ps, null);
		}
	}

}
