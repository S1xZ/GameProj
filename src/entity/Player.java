package entity;

import application.Main;
import entity.base.CollidableEntity;
import entity.base.Entity;
import entity.base.IKillable;
import sharedObject.IRenderable;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Player extends CollidableEntity {
	
	private final static int MAXSPEED = 2;
	
	private float accel = (float) 0.05;
	private float decel = (float) 0.01;
	
	private boolean shoot = false;
	
	private float speed = 0;
	private int speed_angle = 0;
	public int angle = 0; // angle 0 = EAST

	private boolean flashing = false;
	private int flashCounter = 0;
	private int flashDurationCounter = 0;

	public Player(double x, double y) {
		this.x = x;
		this.y = y;
	}

	private void forward() {
		this.x += Math.cos(Math.toRadians(speed_angle)) * speed;
		this.y += Math.sin(Math.toRadians(speed_angle)) * speed;
	}

	private void turn(boolean left) {
		if (left) {
			angle -= 3;
			if (angle < 0)
				angle += 360;
		} else {
			angle += 3;
			if (angle >= 360)
				angle -= 360;
		}
	}

	public void hitByMine() {
		flashing = true;
		flashCounter = 10;
		flashDurationCounter = 10;
	}

	public void update() {
		double t = 1;
		if (flashing) {
			if (flashCounter == 0) {
				this.visible = true;
				flashing = false;
			} else {
				if (flashDurationCounter > 0) {
					this.visible = flashCounter <= 5;
					flashDurationCounter--;
				} else {
					this.visible = true;
					flashDurationCounter = 10;
					flashCounter--;
				}
			}
		} else {
			this.visible = !InputUtility.getKeyPressed(KeyCode.SHIFT);
		}
		if (InputUtility.getKeyPressed(KeyCode.W)) {
			if(speed < MAXSPEED)
			{
				
				speed += accel;
			}
			speed_angle = this.angle;
			forward();
		}
		if (InputUtility.getKeyPressed(KeyCode.J)) {
			shoot = true;
		}
		if (InputUtility.getKeyPressed(KeyCode.A)) {
			turn(true);
		} else if (InputUtility.getKeyPressed(KeyCode.D)) {
			turn(false);
		}
		if (InputUtility.isLeftClickTriggered()) {
			this.x = InputUtility.mouseX;
			this.y = InputUtility.mouseY;
		}
		if (speed > 0 && !InputUtility.getKeyPressed(KeyCode.W))
		{
			forward();
			speed -= decel;
		}
		else if (speed < 0) 
		{
			speed = 0;
		}
		if (this.x > Main.WIDTH)
		{
			this.x = 0;
		}
		if (this.x < 0)
		{
			this.x = Main.WIDTH;
		}
		if(this.y > Main.HEIGHT)
		{
			this.y = 0;
		}
		if(this.y < 0)
		{
			this.y = Main.HEIGHT;
		}
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		
	}

}
