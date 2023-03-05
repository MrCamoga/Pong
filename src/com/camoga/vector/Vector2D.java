package com.camoga.vector;

public class Vector2D {
	private double x;
	private double y;

	public Vector2D() {
		this(0, 0);
	}

	public Vector2D(double x, double y) {
		this.x = x;
		this.y= y;
	}
	
	public Vector2D set(double x, double y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Vector2D add(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Vector2D sub(double x, double y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
	
	public Vector2D div(double x, double y) {
		this.x /= x;
		this.y /= y;
		return this;
	}
	
	public Vector2D div(double s) {
		this.x /= s;
		this.y /= s;
		return this;
	}
	
	public Vector2D mul(double x, double y) {
		this.x *= x;
		this.y *= y;
		return this;
	}
	
	public Vector2D mul(double s) {
		this.x *= s;
		this.y *= s;
		return this;
	}
	
	public Vector2D set(Vector2D vec) {
		this.x = vec.x;
		this.y = vec.y;
		return this;
	}
	
	public Vector2D add(Vector2D vec) {
		this.x += vec.x;
		this.y += vec.y;
		return this;
	}
	
	public Vector2D sub(Vector2D vec) {
		this.x -= vec.x;
		this.y -= vec.y;
		return this;
	}
	
	public Vector2D mul(Vector2D vec) {
		this.x *= vec.x;
		this.y *= vec.y;
		return this;
	}
	
	public Vector2D div(Vector2D vec) {
		this.x /= vec.x;
		this.y /= vec.y;
		return this;
	}
	
	public Vector2D duplicate() {
		return new Vector2D(x, y);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
