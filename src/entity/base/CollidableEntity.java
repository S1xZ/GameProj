package entity.base;

/**
 * Created by: Punya Gunawardana
 * Date created: Aprill 23, 2021
 * Time created: 9:11 AM
 */


public abstract class CollidableEntity extends Entity implements Updatable{
	protected int radius;
	protected int health;
	protected double angle;
	
	public boolean collideWith(CollidableEntity other){
		return Math.hypot(this.x-other.x, this.y-other.y) <= this.radius+other.radius;
	}
	
	public void hit() {
		this.health--;
	}
	
}
