package com.camoga;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.camoga.entity.Ball;
import com.camoga.entity.Paddle;
import com.camoga.gfx.Font;
import com.camoga.gfx.Screen;
import com.camoga.level.Level;
import com.camoga.vector.Vector2D;

@SuppressWarnings("serial")
public class Pong extends Canvas implements Runnable, KeyListener {

	public static int WIDTH = 210;
	public static int HEIGHT = 160;
	public static int SCALE = 3;
	
	public static double UPS = 60D;
	
	private Dimension dimension = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private boolean isRunning;
	
	public static Pong pong;
	
	private JFrame frame;
	private Thread thread;
	private Graphics g;
	private Screen screen;
	private Level level;
	public Ball ball;
	public Paddle[] paddle = new Paddle[2];
	public HUD hud;
	private Font font;
	
	public Pong() {
		pong = this;
		frame = new JFrame("Pong - made by Camoga");
		
		frame.setSize(dimension);
    	frame.setLayout(new BorderLayout());
    	frame.add(this);
    	frame.setResizable(false);
    	frame.setVisible(true);
    	frame.pack();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLocationRelativeTo(null);
    	addKeyListener(this);
	}
	
	public static void main(String[] args) {
		new Pong().start();
	}
	
	public void run() {
		init();
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000/UPS;
		
		int frames = 0;
		int ticks = 0;
		
		double delta = 0;
		long lastTimer = System.currentTimeMillis();
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			
			while(delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
			}
			
			frames++;
			render();
			
			if(System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println("fps: " + frames + ", ups: " + ticks);
				frames = 0;
				ticks = 0;
			}
		}
		
	}
	
	public void init() {
		screen = new Screen(WIDTH, HEIGHT);
		font = new Font();
		level = new Level(WIDTH, HEIGHT);
		ball = new Ball(level, new Vector2D(100, 100));
		paddle[0] = new Paddle(level, new Vector2D(5, HEIGHT/2), 0, false);
		paddle[1] = new Paddle(level, new Vector2D(WIDTH - 5, HEIGHT/2 - 1), 1, true);
		hud = new HUD();
		for(int i = 0; i < paddle.length; i++) {
			level.addEntity(paddle[i]);
		}
		level.addEntity(ball);
	}
	
	public void tick() {
		level.tick();
	}
	
	public void render() {
		BufferStrategy buffer = getBufferStrategy();
		
		if(buffer == null) {
			createBufferStrategy(3);
			return;
		}
		
		g = buffer.getDrawGraphics();
		screen.clear();
		
		font.render(screen, hud.getScore()[0], 1, 20, 20, 0xffffff);
		font.render(screen, hud.getScore()[1], 1, WIDTH - 20, 20, 0xffffff);
		for(int y = 0; y < HEIGHT; y+=6) {
			screen.render(WIDTH/2 + 1, (int) (y*1.7), 2, 6, 0xffffff);
		}
		level.render(screen);
		for(int y = 0; y < screen.height; y++) {
			for(int x = 0; x < screen.width; x++) {
				pixels[x + y * WIDTH] = screen.pixels[x + y * WIDTH];
			}
		}
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);	
		//g.setColor(Color.WHITE);
		//g.drawString(hud.getScore()[0] + "", 50, 20);	
		g.dispose();
		buffer.show();
	}
	
	public synchronized void start() {
		if(thread == null) {
			isRunning = true;
			thread = new Thread(this, "PONG");
			thread.start();
		}
	}
	
	public synchronized void stop() {
		try {
			isRunning = false;
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		for(int i = 0; i < paddle.length; i++) {
			paddle[i].keyPressed(e.getKeyCode());
		}
	}

	public void keyReleased(KeyEvent e) {
		for(int i = 0; i < paddle.length; i++) {
			paddle[i].keyReleased(e.getKeyCode());
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
