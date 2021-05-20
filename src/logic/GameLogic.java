package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import application.Main;
import entity.BigMeteor;
import entity.Bullet;
import entity.MediumMeteor;
import entity.Player;
import entity.SmallMeteor;
import entity.UFO;
import entity.base.Enemy;
import entity.base.Entity;
import entity.base.Updatable;
import javafx.application.Platform;
import sharedObject.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	private Player player;
	private static int globalWaveCount = 0;
	private int enemycount;
	private boolean isGameEnd = false;
	private int waveDelay = 0;
	private int Score = 0;
	private GameOverlay overlay = new GameOverlay();
	
	public GameLogic(){
		enemycount = 0;
		gameObjectContainer = new ArrayList<Entity>();
		isGameEnd = false;
		startGame();
	}
	
	private void startGame()
	{
		overlay.setScore(Score);
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		RenderableHolder.getInstance().add(overlay);
		player = new Player(Main.HEIGHT/2, Main.WIDTH/2);
		addNewObject(player);
	}
	
	private void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	private void newWave() 
	{
		if(waveDelay >= 700)
		{
			overlay.setIsWaveTextVisible(false);
			waveDelay = 0;
			if(!player.isDestroyed() && globalWaveCount != 0)
			{
				player.setHealth(player.getHealth()+1);
			}
			globalWaveCount++;
			if(globalWaveCount % 3 == 0)
			{
				if(globalWaveCount == 3)
				{
					enemycount+=1;
					addNewObject(new UFO());
				}
				else if(globalWaveCount == 6)
				{
					enemycount+=2;
					addNewObject(new UFO());
					addNewObject(new UFO());
				}
				else 
				{
					enemycount+=3;
					addNewObject(new UFO());
					addNewObject(new UFO());
					addNewObject(new UFO());
				}
			}
			else 
			{
				enemycount+=5;
				addNewObject(new BigMeteor());
				addNewObject(new MediumMeteor());
				addNewObject(new MediumMeteor());
				addNewObject(new MediumMeteor());
				addNewObject(new MediumMeteor());		
			}
		}
		
		else
		{
			waveDelay++;
		}
		if(waveDelay == 300)
		{
			overlay.setIsWaveTextVisible(true);
			overlay.setCurrenttext("Wave "+String.valueOf(globalWaveCount+1));
		}
	}
	
	public void logicUpdate(){
		
		for(int i = 0;i<gameObjectContainer.size();i++)
		{
			overlay.setHp(player.getHealth());
			if (gameObjectContainer.get(i) instanceof Updatable) {
				Updatable E = (Updatable) gameObjectContainer.get(i);
				E.update();
			}
			if (gameObjectContainer.get(i) instanceof Enemy)
			{
				Enemy E = (Enemy) gameObjectContainer.get(i);
				if(this.player.collideWith(E) && !player.getFlashing() && !player.isDestroyed()) {
					player.hit();
					E.hit();
				}
				if (E instanceof UFO)
				{
					UFO I = (UFO) E;
					if(I.canShoot())
					{
						addNewObject(new Bullet(I.getX(), I.getY(), I.getPlayerAngle(player), false));
					}
				}
			}
			
			if (gameObjectContainer.get(i) instanceof Bullet)
			{
				Bullet E = (Bullet) gameObjectContainer.get(i);
				if(!E.isPlayerBullet && !player.getFlashing() && !player.isDestroyed())
				{
					if(player.collideWith(E)) {
					player.hit();
					E.hit();
					}
				}
				else {
					for(Entity e : gameObjectContainer)
					{
						if (e instanceof Enemy)
						{
							if(((Enemy) e).collideWith(E)) {
								((Enemy) e).hit();
								E.hit();
							}
						}
					}
				}
			}

			if (gameObjectContainer.get(i).isDestroyed())
			{
				if (gameObjectContainer.get(i) instanceof Enemy)
				{
					enemycount--;
					if(gameObjectContainer.get(i) instanceof BigMeteor)
					{
						BigMeteor e = (BigMeteor) gameObjectContainer.get(i);
						addNewObject(new MediumMeteor(e.getX(),e.getY()));
						addNewObject(new MediumMeteor(e.getX(),e.getY()));
						enemycount+=2;
					}
					if(gameObjectContainer.get(i) instanceof MediumMeteor)
					{
						MediumMeteor e = (MediumMeteor) gameObjectContainer.get(i);
						addNewObject(new SmallMeteor(e.getX(),e.getY()));
						addNewObject(new SmallMeteor(e.getX(),e.getY()));
						enemycount+=2;
					}
				}
				gameObjectContainer.remove(i);
			}
		}
		
		if(player.canShoot()) {
			addNewObject(new Bullet(player.getX(), player.getY(), player.getAngle(), true));
		}
		if(enemycount == 0 && !isGameEnd)
		{
			newWave();
		}
	}
}
