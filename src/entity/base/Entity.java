package entity.base;

/**
 * Created by: Punya Gunawardana
 * Date created: Aprill 23, 2021
 * Time created: 9:21 AM
 */

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{

	protected double x,y;
	protected int z;
	protected boolean visible,destroyed;
	
	protected Entity(){
		visible = true;
		destroyed = false;
	}
	
	@Override
	public boolean isDestroyed(){
		return destroyed;
	}
	
	@Override
	public boolean isVisible(){
		return visible;
	}
	
	@Override
	public int getZ(){
		return z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
}
