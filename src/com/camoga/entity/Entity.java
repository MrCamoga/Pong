package com.camoga.entity;

import java.awt.Rectangle;

import com.camoga.gfx.Screen;
import com.camoga.level.Level;
import com.camoga.vector.Vector2D;

@SuppressWarnings("serial")
public abstract class Entity extends Rectangle {
	protected Vector2D pos;
	protected Vector2D movement;
	
	protected Level level;
	
	public Entity(Level level, Vector2D pos) {
		this.pos = pos;
		this.level = level;
		movement = new Vector2D();
	}
	
	public Entity(Level level) {
		this(level, new Vector2D());
	}
	
	public Vector2D getMovement() {
		return movement;
	}
	
	public Vector2D getPos() {
		return pos;
	}
	
	public Entity setMovement(int x, int y) {
		movement.set(x, y);
		return this;
	}
	
	public abstract void render(Screen screen);
	
	public abstract void tick();
}
