package application;

import gui.GameScreen;
import gui.mainMenu;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Main extends Application{
	
	public final static int WIDTH = 640;
	public final static int HEIGHT = 480;
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Asteriod");
		
		GameLogic logic = new GameLogic();
		GameScreen gameScreen = new GameScreen(WIDTH, HEIGHT);
		root.getChildren().add(gameScreen);
		gameScreen.requestFocus();
		
		primaryStage.show();
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
			}
		};
		animation.start();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
