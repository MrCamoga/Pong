package com.camoga.gfx;

import java.util.HashMap;

public class Font {
	
	public HashMap<Integer, int[][]> fonts = new HashMap<Integer, int[][]>();
	
	public Font() {
		fonts.put(0, _0);
		fonts.put(1, _1);
		fonts.put(2, _2);
		fonts.put(3, _3);
		fonts.put(4, _4);
		fonts.put(5, _5);
		fonts.put(6, _6);
		fonts.put(7, _7);
		fonts.put(8, _8);
		fonts.put(9, _9);
	}
	
	public static final int[][] _0 = new int[][] {
		{0,1,1,1,0},
		{1,0,0,0,1},
		{1,0,0,0,1},
		{1,0,0,0,1},
		{1,0,0,0,1},
		{1,0,0,0,1},
		{0,1,1,1,0},
	};
		
	public static final int[][] _1 = new int[][] {
		{0,0,1,0,0},
		{0,1,1,0,0},
		{0,0,1,0,0},
		{0,0,1,0,0},
		{0,0,1,0,0},
		{0,0,1,0,0},
		{0,1,1,1,0},
	};
	
	public static final int[][] _2 = new int[][] {
		{0,1,1,1,0},
		{1,0,0,0,1},
		{0,0,0,0,1},
		{0,0,0,1,0},
		{0,0,1,0,0},
		{0,1,0,0,0},
		{1,1,1,1,1},
	};
	
	public static final int[][] _3 = new int[][] {
		{0,1,1,1,0},
		{0,0,0,0,1},
		{0,0,0,0,1},
		{0,1,1,1,0},
		{0,0,0,0,1},
		{0,0,0,0,1},
		{0,1,1,1,0},
	};
	
	public static final int[][] _4 = new int[][] {
		{0,0,0,1,0},
		{0,0,1,1,0},
		{0,1,0,1,0},
		{1,0,0,1,0},
		{1,1,1,1,1},
		{0,0,0,1,0},
		{0,0,0,1,0},
	};
	
	public static final int[][] _5 = new int[][] {
		{1,1,1,1,1},
		{1,0,0,0,0},
		{1,0,0,0,0},
		{0,1,1,1,0},
		{0,0,0,0,1},
		{1,0,0,0,1},
		{0,1,1,1,0},
	};
	
	public static final int[][] _6 = new int[][] {
		{0,1,1,1,0},
		{1,0,0,0,0},
		{1,0,0,0,0},
		{1,1,1,1,0},
		{1,0,0,0,1},
		{1,0,0,0,1},
		{0,1,1,1,0},
	};
	
	public static final int[][] _7 = new int[][] {
		{1,1,1,1,1},
		{0,0,0,0,1},
		{0,0,0,0,1},
		{0,0,0,1,0},
		{0,0,0,1,0},
		{0,0,1,0,0},
		{0,0,1,0,0},
	};
	
	public static final int[][] _8 = new int[][] {
		{0,1,1,1,0},
		{1,0,0,0,1},
		{1,0,0,0,1},
		{0,1,1,1,0},
		{1,0,0,0,1},
		{1,0,0,0,1},
		{0,1,1,1,0},
	};
	
	public static final int[][] _9 = new int[][] {
		{0,1,1,1,0},
		{1,0,0,0,1},
		{1,0,0,0,1},
		{0,1,1,1,1},
		{0,0,0,0,1},
		{1,0,0,0,1},
		{0,1,1,1,0},
	};
	
	public void render(Screen screen, int number, int size, int x, int y, int color) {
		String strn = String.valueOf(number);
		String[] split = strn.split("(?!^)");
		int[] digits = new int[split.length];
		for(int i=0; i < split.length; i++) {
			 digits[i] = Integer.parseInt(split[i]);
		}
		
		int[][][] num = new int[digits.length][][];
		for(int i = 0; i < digits.length; i++) {
			num[i] = fonts.get(digits[i]);
		}
		for(int i = 0; i < digits.length; i++) {
			for(int y1 = 0; y1 < num[0].length; y1++) {
				for(int x1 = 0; x1 < num[0][0].length; x1++) {
					int color1 = color;
					if(num[i][y1][x1] != 1) color1 = -1;
					screen.render(x + x1 + i * 6 - digits.length*3, y + y1, size, size, color1);
				}
			}
		}
	}
}
