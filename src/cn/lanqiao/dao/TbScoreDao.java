package cn.lanqiao.dao;

import java.util.List;

import cn.lanqiao.model.TbScore;


public interface TbScoreDao {
	public List<TbScore> list();
	public void insert (TbScore  tbscore);
	public void remove (TbScore  tbscore);
	public void update (TbScore  tbscore);
}
