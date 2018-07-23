package cn.lanqiao.dao;

import java.util.List;

import cn.lanqiao.model.TbClass;


public interface TbClassDao {
	public List<TbClass> list();
	public void insert (TbClass  tbclass);
	public void remove (TbClass  tbclass);
	public void update (TbClass  tbclass);
}
