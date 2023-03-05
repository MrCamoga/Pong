package com.camoga.entity;

import com.camoga.Pong;
import com.camoga.gfx.Screen;
import com.camoga.level.Level;
import com.camoga.vector.Vector2D;

@SuppressWarnings("serial")
public class Ball extends Entity {
	public Ball(Level level, Vector2D pos) {
		super(level, pos);
		this.width = 3;
		this.height = 3;
		movement.set(50, 50);
		movement.div(60, 60);
	}
	
	public void tick() {
		if(movement.getY() > 2) movement.set(movement.getX(), 2);
		collide();
		pos.add(movement);
		this.x = (int) pos.getX();
		this.y = (int) pos.getY();
		setBounds(this);
		//System.out.println(pos.getX() + ", " + pos.getY());
	}
	
	public void collide() {
		if(pos.getX() <= 0) {
			//movement.mul(-1, 1);
			Pong.pong.hud.addScore(1, 1);
			pos.set(Pong.WIDTH/2, Pong.HEIGHT/2);
		}
		if(pos.getY() <= 0) {
			movement.mul(1, -1);
		}
		if(pos.getX() >= level.width - width + 1) {
			//movement.mul(-1, 1);
			Pong.pong.hud.addScore(0, 1);
			pos.set(Pong.WIDTH/2, Pong.HEIGHT/2);
		}
		if(pos.getY() >= level.height - height + 1) {
			movement.mul(1, -1);
		}
		if(intersects(Pong.pong.paddle[0])) {
			movement.add(Pong.pong.paddle[0].movement).mul(-1, 1);
			//movement.mul(-1, 1);
		}
		
		if(intersects(Pong.pong.paddle[1])) {
			movement.add(Pong.pong.paddle[1].movement).mul(-1, 1);
			//movement.mul(-1, 1);
		}
	}
	
	public void render(Screen screen) {
		screen.render((int)pos.getX(), (int)pos.getY(), width, height, 0xaa0000);
	}
}
