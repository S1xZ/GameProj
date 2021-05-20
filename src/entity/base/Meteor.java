package entity.base;

import application.Main;

public abstract class Meteor extends Enemy{

	

	public Meteor(double x, double y, int health,double speed) {
		super(x, y, health);
		angle = RAND.nextDouble()*360;
		this.speed = speed;
	}

	
	@Override
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
		
	}
	
	

}
