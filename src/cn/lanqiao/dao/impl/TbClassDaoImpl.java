package cn.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.lanqiao.dao.TbClassDao;
import cn.lanqiao.model.TbClass;
import cn.lanqiao.util.JdbcUtil;

public class TbClassDaoImpl implements TbClassDao {

	@Override
	public List<TbClass> list() {
		List <TbClass> tcla =new ArrayList<TbClass>();
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//1.获取连接
			conn =JdbcUtil.getConnection();
			//2.创建Statement
			st=conn.createStatement();
			//3.执行查询
			String sql="select * from Tb_Class";
			rs= st.executeQuery(sql);
			TbClass tbclass=null;
			while (rs.next()){
				Integer classId = rs.getInt("Class_id") ;
				String className = rs.getString("Class_name"); 
				tbclass = new TbClass(classId, className);
				tcla.add(tbclass);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, st, rs);
		}
		return tcla;
	}

	@Override
	public void insert(TbClass tbclass) {
		Connection conn =null;
		PreparedStatement ps =null;
		try {
			conn=JdbcUtil.getConnection();
			String sql="insert into Tb_Class values (?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,tbclass.getClassId());
			ps.setString(2, tbclass.getClassName());
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, null);
		}
		
	}

	@Override
	public void remove(TbClass tbclass) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql ="delete from Tb_Class where Class_id=?";
			ps = conn.prepareStatement(sql);
			//ORMapping;
			ps.setInt(1,tbclass.getClassId()); 
			ps.executeQuery();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			JdbcUtil.close(conn, ps, null);
		}

	}

	@Override
	public void update(TbClass tbclass) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql ="update Tb_Class set Class_id=?,Class_name=? where Class_id=?";
			ps = conn.prepareStatement(sql);
			//ORMapping;
			ps.setInt(1, tbclass.getClassId());
			ps.setString(2,tbclass.getClassName());
			ps.setInt(3, tbclass.getClassId()); 
			ps.executeQuery();	
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			JdbcUtil.close(conn, ps, null);
		}
	}

}


