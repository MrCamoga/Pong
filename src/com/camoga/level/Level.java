package com.camoga.level;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.camoga.Pong;
import com.camoga.entity.Entity;
import com.camoga.gfx.Screen;

public class Level {
	private List<Rectangle> elements = new ArrayList<Rectangle>();
	private List<Entity> entities = new ArrayList<Entity>();
	
	public int width, height;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		elements.add(new Rectangle(0, 0, Pong.WIDTH, Pong.HEIGHT));
	}
	
	public void render(Screen screen) {
		for(Entity e : entities) {
			e.render(screen);
		}
	}
	
	public void tick() {
		for(Entity e : entities) {
			e.tick();
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
}
