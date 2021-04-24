package gui;

import application.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class mainMenu extends StackPane {
	
	private Font mainFont = new Font(20);
	
	
	public mainMenu()
	{
		
		Canvas canvas = new Canvas(Main.WIDTH,Main.HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		Universe uni = new Universe();
		
		Background bg = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
		
		this.getChildren().add(canvas);
		
		this.setPrefSize(Main.WIDTH, Main.HEIGHT);
		this.setBackground(bg);
		
		VBox options = new VBox(30);
		
		options.setAlignment(Pos.CENTER);
		options.setTranslateY(100);
		
		Button startBtn = new Button("Start");
		startBtn.setFont(mainFont);
		Button helpBtn = new Button("Help");
		helpBtn.setFont(mainFont);
		Button creditBtn = new Button("Credit");
		creditBtn.setFont(mainFont);
		Button exitBtn = new Button("Exit");
		exitBtn.setFont(mainFont);
		
		options.getChildren().addAll(startBtn,helpBtn,creditBtn,exitBtn);
		
		
	}
}
