package com.cn.util;

public class TblRankingDate {

	private String rankingDate;
	private double productivity;
	
	
	public TblRankingDate(String rankingDate, double productivity) {
		super();
		this.rankingDate = rankingDate;
		this.productivity = productivity;
	}
	
	public String getRankingDate() {
		return rankingDate;
	}
	public void setRankingDate(String rankingDate) {
		this.rankingDate = rankingDate;
	}
	public double getProductivity() {
		return productivity;
	}
	public void setProductivity(double productivity) {
		this.productivity = productivity;
	}
	
	
}
