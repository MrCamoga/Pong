package com.camoga.gfx;

public class Screen {
	public int width, height;
	public int pixels[];
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		
		pixels = new int[width * height];
	}
	
	public void clear() {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				pixels[x + y * width] = 0;
			}
		}
	}
	
	public void render(int x, int y, int width, int height, int color) {
		for(int ya = y; ya < height + y; ya++) {
			for(int xa = x; xa < width + x; xa++) {
				if(xa < 0 || ya < 0 || xa >= this.width || ya >= this.height) continue;
				if(color != -1)
				pixels[xa + ya * this.width] = color;
			}			
		}
	}
}
