package com.camoga.entity.ai;

import com.camoga.Pong;
import com.camoga.entity.Ball;
import com.camoga.entity.Paddle;
import com.camoga.vector.Vector2D;

public class AI {
	private Paddle ai;
	private Paddle player;
	private Ball ball;
	private int id;
	
	private Vector2D ballMovement;
	private Vector2D ballPos;
	
	public AI(Paddle ai, Paddle player, Ball ball, int id) {
		this.ai = ai;
		this.ball = ball;
		this.player = player;
		this.id = id;
	}
	
	public void tick() {
		if((id == 1 && ball.getMovement().getX() > 0) || (id == 0 && ball.getMovement().getX() < 0)) {			

			ballMovement = ball.getMovement().duplicate();
			ballPos = ball.getPos().duplicate();
			
			while(ballPos.getX() < ai.getPos().getX()) {
				ballPos.add(ballMovement);
			}
			trackBall();
		} else {
			if(ai.getY() != Pong.HEIGHT/2)
			moveTo(Pong.HEIGHT/2);
		}
	}
	
	public void moveTo(int y) {
		if(ai.getY() > y) ai.getMovement().set(0, -3);
		else ai.getMovement().set(0, 3);
		if(Math.abs(ai.getY() - y) < 5) ai.getMovement().set(0, 0);
	}
	
	public void trackBall() {
		if(ballPos.getY() > ai.getY() + ai.height/2) {
			ai.setMovement(0, 3);
		} else if(ballPos.getY() < ai.getY() + ai.height/2){
			ai.setMovement(0, -3);
		}
		if(Math.abs(ballPos.getY() - ai.getY()) < 5) ai.setMovement(0, 0);
		if(ballPos.getY() == ai.getY() + ai.height/2) {
			//ai.setMovement(0, 0);
		}
	}
}
