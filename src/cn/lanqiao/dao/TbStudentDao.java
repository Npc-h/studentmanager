package cn.lanqiao.dao;

import java.util.List;

import cn.lanqiao.model.TbStudent;


public interface TbStudentDao {
	public List<TbStudent> list();
	public void insert (TbStudent  tbstudent);
	public void remove (TbStudent  tbstudent);
	public void update (TbStudent  tbstudent);
	public List<TbStudent> vaguaSearch(String name);
}
