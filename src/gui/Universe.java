package gui;

import java.util.Random;

import application.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Universe {
	static int posX;
	static int posY;
	private static int h;
	private static int w;
	private static int r;
	private static int g;
	private static int b;
	private static double opacity;
	private static final Random RAND = new Random();
	
	public Universe() {
		posX = RAND.nextInt(Main.WIDTH);
		posY = 0;
		w = RAND.nextInt(5) + 1;
		h =  RAND.nextInt(5) + 1;
		r = RAND.nextInt(100) + 150;
		g = RAND.nextInt(100) + 150;
		b = RAND.nextInt(100) + 150;
		opacity = RAND.nextFloat();
		if(opacity < 0) opacity *=-1;
		if(opacity > 0.5) opacity = 0.5;
	}
	
	public static void draw(GraphicsContext gc) {
		if(opacity > 0.8) opacity-=0.01;
		if(opacity < 0.1) opacity+=0.01;
		gc.setFill(Color.rgb(r, g, b, opacity));
		gc.fillOval(posX, posY, w, h);
		posY+=20;
	}
}

