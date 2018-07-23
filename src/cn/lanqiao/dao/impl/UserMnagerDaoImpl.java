package cn.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.lanqiao.dao.UserMnagerDao;
import cn.lanqiao.model.UserMnager;
import cn.lanqiao.util.JdbcUtil;

public class UserMnagerDaoImpl implements UserMnagerDao {
/**
 * 查询所有用户
 */
	@Override
	public List<UserMnager> list() {
		List<UserMnager> datas = null;
		try {
			QueryRunner queryRunner = new QueryRunner();
			datas = queryRunner.query(JdbcUtil.getConnection(), "select * from UserMnager",new BeanListHandler<>(UserMnager.class));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return datas;
	}

	/**
	 * 增加用户
	 */
	@Override
	public void insert(UserMnager usermnager) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into USERMNAGER(USERNAME,USERPWD) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usermnager.getUserName());
			ps.setString(2, usermnager.getUserPwd());
			ps.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JdbcUtil.close(conn, ps, null);
		}
		
	}

}
