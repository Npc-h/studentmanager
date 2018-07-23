package cn.lanqiao.service;

import java.util.List;

import cn.lanqiao.model.TbStudent;

public interface TbStudentService {
	public List<TbStudent> getAllTbStudent();
	public void insertTbStudent(TbStudent tbstudent);
	public void removeTbStudent(TbStudent tbstudent);
	public void updateTbStudent(TbStudent tbstudent);
	public List<TbStudent> getvaguaSearch(String name);
}
