package cn.lanqiao.dao;

import java.util.List;

import cn.lanqiao.model.TbCourse;


public interface TbCourseDao {
	public List<TbCourse> list();
	public void insert (TbCourse  tbcourse);
	public void remove (TbCourse  tbcourse);
	public void update (TbCourse  tbcourse);
}
