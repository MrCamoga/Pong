package com.camoga.entity;

import java.awt.event.KeyEvent;

import com.camoga.Pong;
import com.camoga.entity.ai.AI;
import com.camoga.gfx.Screen;
import com.camoga.level.Level;
import com.camoga.vector.Vector2D;

@SuppressWarnings("serial")
public class Paddle extends Entity {

	private int id;
	private AI ai;
	
	public Paddle(Level level, Vector2D pos, int id, boolean isAI) {
		super(level, pos);
		this.width = 2;
		this.height = 18;
		this.id = id;
		if(isAI) ai = new AI(this, null, Pong.pong.ball, id);
	}

	public void render(Screen screen) {
		screen.render((int) pos.getX(), (int) pos.getY(), width, height, 0xffffff);
	}

	public void tick() {
		if(ai != null) {
			ai.tick();
		}
		pos.add(movement);
		this.x = (int) pos.getX();
		this.y = (int) pos.getY();
		setBounds(this);
		collide();
	}
	
	public void collide() {
		if(pos.getY() <= 0) pos.set(pos.getX(), 0);
		if(pos.getY() >= Pong.HEIGHT - height) pos.set(pos.getX(), Pong.HEIGHT - height);
	}
	
	public void keyPressed(int keyCode) {
		if(id == 0) {
			if(keyCode == KeyEvent.VK_W) movement.set(0, -1.8);
			if(keyCode == KeyEvent.VK_S) movement.set(0, 1.8);
		}
		if(id == 1) {
			if(keyCode == KeyEvent.VK_UP) movement.set(0, -1.8);
			if(keyCode == KeyEvent.VK_DOWN) movement.set(0, 1.8);
		}
	}
	
	public double getX() {
		return pos.getX();
	}
	
	public double getY() {
		return pos.getY();
	}
	
	public void keyReleased(int keyCode) {
		if(id == 0) {
			if(keyCode == KeyEvent.VK_W && movement.getY() < 0) movement.set(0, 0);
			else if(keyCode == KeyEvent.VK_S && movement.getY() > 0) movement.set(0, 0);
		}
		if(id == 1) {
			if(keyCode == KeyEvent.VK_UP && movement.getY() < 0) movement.set(0, 0);
			else if(keyCode == KeyEvent.VK_DOWN && movement.getY() > 0) movement.set(0, 0);
		}
	}
}
