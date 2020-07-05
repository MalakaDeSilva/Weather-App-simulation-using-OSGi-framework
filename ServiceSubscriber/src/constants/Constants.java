package constants;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Constants {
	
	//Path to images
	private static final String IMAGE_PATH = "C:\\Users\\blitz\\Desktop\\SA Assignment\\ServiceConsumer\\icons\\";
	
	//Name of app
	public static final String APP_NAME = "Weather App";
	
	//Names of the two cities used
	public static final String CITY_ONE_NAME = "Colombo";
	public static final String CITY_TWO_NAME = "Jaffna";
	
	//Used to compare the weather from the producer to display the corresponding image
	public static final String SUNNY_WEATHER = "sunny";
	public static final String RAINY_WEATHER = "rainy";
	public static final String WINDY_WEATHER = "windy";
	public static final String CLOUDY_WEATHER = "cloudy";
	
	//Names of the images used for different weathers
	public static final ImageIcon SUNNY_IMAGE = new ImageIcon(new ImageIcon(IMAGE_PATH + "sunny.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
	public static final ImageIcon RAINY_IMAGE = new ImageIcon(new ImageIcon(IMAGE_PATH + "rainy.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
	public static final ImageIcon WINDY_IMAGE = new ImageIcon(new ImageIcon(IMAGE_PATH + "windy.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
	public static final ImageIcon CLOUDY_IMAGE = new ImageIcon(new ImageIcon(IMAGE_PATH + "cloudy.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
	
	//Name of the image used for temperaturePanel
	public static final ImageIcon TEMPERATURE_IMAGE = new ImageIcon(new ImageIcon(IMAGE_PATH + "icon.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
	
	// OpenWeather API KEY
	public static final String APIKey = "&appid=";
	
	// OpenWeather API url
	public static final String _URL = "https://api.openweathermap.org/data/2.5/weather?q=";
}
