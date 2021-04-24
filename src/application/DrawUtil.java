package application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class DrawUtil {
	
	public static void drawSprite(GraphicsContext gc,int x,int y,Image img) {
		gc.drawImage(img, x, y);
	}
	
}