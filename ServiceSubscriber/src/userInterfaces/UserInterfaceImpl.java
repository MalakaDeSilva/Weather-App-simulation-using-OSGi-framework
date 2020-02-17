package userInterfaces;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants;
import model.Info;


public class UserInterfaceImpl implements UserInterface{
	
	Info producerInfo1;
	Info producerInfo2;
	Info newProducer;
	
	JFrame frame=new JFrame();

	JPanel mainPanel = new JPanel(new GridLayout(2, 0));
	
	//JPanels for holding different information displayed
	JPanel weatherPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));
	JPanel temperaturePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));
	JPanel selectCityTextPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 80));
	JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));

	JButton cityOneButton = new JButton(Constants.CITY_ONE_NAME);
	JButton cityTwoButton = new JButton(Constants.CITY_TWO_NAME);
	JButton variableCityButton;
	
	JLabel temp = new JLabel();
	
	//Labels for holding images
	JLabel temperatureImage = new JLabel();
	JLabel weatherImage = new JLabel();
	
	//Label for holding welcome text
	JLabel selectCityLabel = new JLabel();
	
	//Label for holding select button text
	JLabel selectButtonLabel = new JLabel();
	
	public static boolean isStart = true;

	//Displays homepage UI
	public void createHomeUI(Info producerInfo1, Info producerInfo2) {
		
		this.producerInfo1 = producerInfo1;
		this.producerInfo2 = producerInfo2;
		
		//Clears the existing information form the JPanels
		headerActions();

		mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), Constants.APP_NAME + " Home"));

		selectCityLabel.setText("Select City");
		
		//Sets functionality to button
		cityOneButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				createCityUI(producerInfo1);
			} 
		} );
		
		//Sets functionality to button
		cityTwoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				createCityUI(producerInfo2);
			} 
		} );
		
		buttonPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
		
		selectCityTextPanel.add(selectCityLabel);
		buttonPanel.add(cityOneButton);
		buttonPanel.add(cityTwoButton);
		
		//Displays panels in the JFrame
		homeUIFooterActions();
	}

	//Displays forecast of selected city 
	private void createCityUI(Info currentProducer) {
		
		//Stores the name of the current city
		String currentCity;
		
		//Clears the existing information form the JPanels
		headerActions();
		
		mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), Constants.APP_NAME));

		temperatureImage.setIcon(Constants.TEMPERATURE_IMAGE);
		
		//Sets sunnyImage if producer weather is sunny
		if(currentProducer.getWeather().toLowerCase().equals(Constants.SUNNY_WEATHER))
			weatherImage.setIcon(Constants.SUNNY_IMAGE);
		
		//Sets rainyImage if producer weather is rainy
		else if(currentProducer.getWeather().toLowerCase().equals(Constants.RAINY_WEATHER))
			weatherImage.setIcon(Constants.RAINY_IMAGE);
		
		//Sets windyImage if producer weather is windy
		else if(currentProducer.getWeather().toLowerCase().equals(Constants.WINDY_WEATHER))
			weatherImage.setIcon(Constants.WINDY_IMAGE);
		
		//Sets cloudyImage if producer weather is cloudy
		else if(currentProducer.getWeather().toLowerCase().equals(Constants.CLOUDY_WEATHER))
			weatherImage.setIcon(Constants.CLOUDY_IMAGE);
		
		//Sets temperature from producer
		temp.setText(String.valueOf(currentProducer.getTemperature()) + " °C");
		
		/*
		 *Assigns the other producer to newProducer for recursive calling of 'createCityUI(Info currentProducer)'
		 * */
		if(currentProducer.equals(producerInfo1)) {
		
			this.newProducer = producerInfo2;
			currentCity = Constants.CITY_ONE_NAME;
			variableCityButton = new JButton(Constants.CITY_TWO_NAME);
		}
		
		else {
			
			this.newProducer = producerInfo1;
			currentCity = Constants.CITY_TWO_NAME;
			variableCityButton = new JButton(Constants.CITY_ONE_NAME);
		}
				
		//Sets functionality to button
		variableCityButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				createCityUI(newProducer);
			} 
		} );

		//Adds information to relevant JPanels
		buttonPanel.add(variableCityButton);
		temperaturePanel.add(temperatureImage);
		temperaturePanel.add(temp);
		weatherPanel.add(weatherImage);
		
		buttonPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Select City"));
		temperaturePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Temperature of " + currentCity));
		weatherPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Weather of " + currentCity));
		
		//Displays panels in the JFrame
		cityUIFooterActions();
	}
	
	//Clears the existing information form the JPanels
	private void headerActions() {
		
		mainPanel.remove(selectCityTextPanel);
		buttonPanel.removeAll();
		temperaturePanel.removeAll();
		weatherPanel.removeAll();
	}
	
	//Displays panels of createHomeUI() in the JFrame
	private void homeUIFooterActions() {
		
		mainPanel.add(selectCityTextPanel);
		mainPanel.add(buttonPanel);

		frame.add(mainPanel);
		frame.setSize(400, 400);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Displays panels of createCityUI() in the JFrame
	private void cityUIFooterActions() {

		mainPanel.add(weatherPanel);
		mainPanel.add(temperaturePanel);
		mainPanel.add(buttonPanel);

		frame.add(mainPanel);
		frame.setSize(400, 400);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void closeGUI() {
		System.exit(JFrame.EXIT_ON_CLOSE);
	}
}