package cn.lanqiao.service;

import java.util.List;

import cn.lanqiao.model.TbScore;

public interface TbScoreService {
	public List<TbScore> getAllTbScore();
	public void insertTbScore(TbScore tbscore);
	public void removeTbScore(TbScore tbscore);
	public void updateTbScore(TbScore tbscore);
}
