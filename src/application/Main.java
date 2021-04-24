package application;

import gui.mainMenu;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Game;

public class Main extends Application{
	
	public final static int WIDTH = 800;
	public final static int HEIGHT = 600;
	
	
	private Pane mainMenu = new mainMenu();
	private Pane root = new Pane();
	
	private Parent startGame()
	{
		AnimationTimer timer = new AnimationTimer() {
		Game game = new Game();
			@Override
			public void handle(long now) {
				game.update();
			}
		};
		
		timer.start();
		
		return root;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("GameProj");
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
