package com.camoga;

public class HUD {
	private int p1Score = 0, p2Score = 0;
	
	public HUD() {
		
	}
	
	public void resetScore() {
		p1Score = 0;
		p2Score = 0;
	}
	
	public void setScore(int i, int score) {
		if(i == 0) p1Score = score;
		if(i == 1) p2Score = score;
	}
	
	public void addScore(int i, int score) {
		if(i == 0) p1Score += score;
		if(i == 1) p2Score += score;
	}
	
	public void subScore(int i, int score) {
		if(i == 0) p1Score += score;
		if(i == 1) p2Score += score;
	}
	
	public int[] getScore() {
		return new int[]{p1Score, p2Score};
	}
}
