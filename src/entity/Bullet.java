package entity;

import application.Main;
import entity.base.CollidableEntity;
import entity.base.Enemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class Bullet extends CollidableEntity{
	
	private final static int SPEED = 3;
	private final static int TIMECAP = 200;
	
	private int CurrentTime = 0;
	private double angle;
	public boolean isPlayerBullet;
	
	public Bullet(double x, double y,double d,boolean playerBullet) {
		this.x = x;
		this.y = y;
		this.angle = d;
		this.isPlayerBullet = playerBullet;
		this.health = 1;
		this.radius = 1;
	}
	
	
	public void onCollision(CollidableEntity entity){
		if(entity instanceof Player && !isPlayerBullet) { //If not Player bullet and Hit Player
			entity.hit();
		}
		if(entity instanceof Enemy && isPlayerBullet) { //If Player bullet and Hit Enemy
			entity.hit();
		}
		this.hit();
	}
	
	private void forward() {
		this.x += Math.cos(Math.toRadians(angle)) * SPEED;
		this.y += Math.sin(Math.toRadians(angle)) * SPEED;
	}
	
	public void update() {
		forward();
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
		if(CurrentTime >=  TIMECAP) { //MaximumBulletTraveltime
			CurrentTime = 0;
			this.hit();
		} else {
			CurrentTime++;
		}
		
	}
	
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(x, y, 3, 3);
	}

	@Override
	public void hit() {
		this.destroyed = true;
		this.visible = false;
	}

}
