package entity;

import entity.base.Meteor;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import logic.Sprites;

public class SmallMeteor extends Meteor{
	
	private final static int HEALTH = 1;
	private final static Image[] SpriteArr = {Sprites.METEORSMALL1_SPIRTE,Sprites.METEORSMALL2_SPRITE};
	private Image Sprite;
	private final static int SPPED = 2;
	
	public SmallMeteor(double x, double y) {
		super(x, y, HEALTH,SPPED);
		angle = RAND.nextDouble()*360;
		this.radius = (int) (SpriteArr[0].getWidth()/2);
		int index = RAND.nextInt(SpriteArr.length);
	    Sprite = SpriteArr[index];
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.TRANSPARENT);
		gc.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 360, ArcType.OPEN);
		gc.translate(x, y);
		gc.setFill(Color.YELLOW);
		gc.drawImage(Sprite, -Sprite.getWidth()/2, -Sprite.getHeight()/2, Sprite.getWidth(), Sprite.getHeight());
		gc.translate(-x, -y);
	}
	
}
