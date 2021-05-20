package entity;

import java.util.Random;

import application.Main;
import entity.base.Enemy;
import entity.base.Meteor;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import logic.Sprites;

public class BigMeteor extends Meteor{

	
	private final static int HEALTH = 3;
	private final static Image SPRITE = Sprites.METEORBIG_SPRITE;
	private static final double SPEED = 1;	
	
	public BigMeteor() {
		super(-20,-20,HEALTH,SPEED);
		this.radius = (int) (SPRITE.getWidth()/2);
		randomPos();
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.TRANSPARENT);
		gc.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 360, ArcType.OPEN);
		gc.translate(x, y);
		gc.setFill(Color.YELLOW);
		gc.drawImage(SPRITE, -SPRITE.getWidth()/2, -SPRITE.getHeight()/2, SPRITE.getWidth(), SPRITE.getHeight());
		gc.translate(-x, -y);
	}
}
