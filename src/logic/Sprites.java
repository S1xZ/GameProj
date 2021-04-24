package logic;

import javafx.scene.image.Image;

public class Sprites {
	private static String MeteorBig_path = ClassLoader.getSystemResource("res/MeteorBig.png").toString();
	private static String MeteorMedium1_path = ClassLoader.getSystemResource("res/MeteorMedium1.png").toString();
	private static String MeteorMedium2_path = ClassLoader.getSystemResource("res/MeteorMedium2.png").toString();
	private static String MeteorSmall1_path = ClassLoader.getSystemResource("res/MeteorSmall1.png").toString();
	private static String MeteorSmall2_path = ClassLoader.getSystemResource("res/MeteorSmall2.png").toString();
	private static String Player_path = ClassLoader.getSystemResource("res/Player.png").toString();
	private static String UFO_path = ClassLoader.getSystemResource("res/UFO.png").toString();
	
	
	public static Image MeteorBigprites = new Image(MeteorBig_path);
	public static Image MeteorMedium1sprites = new Image(MeteorMedium1_path);
	public static Image MeteorMedium2sprites = new Image(MeteorMedium2_path);
	public static Image MeteorSmall1sprites = new Image(MeteorSmall1_path);
	public static Image MeteorSmall2sprites = new Image(MeteorSmall2_path);
	public static Image Playersprites = new Image(Player_path);
	public static Image UFOsprites = new Image(UFO_path);
	
}
