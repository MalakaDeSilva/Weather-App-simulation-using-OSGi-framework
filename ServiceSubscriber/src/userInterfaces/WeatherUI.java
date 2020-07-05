package userInterfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JMenuBar;

public class WeatherUI {

	private JFrame frmWeatherApp;
	private JTextField txtCityName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherUI window = new WeatherUI();
					window.frmWeatherApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WeatherUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWeatherApp = new JFrame();
		frmWeatherApp.setTitle("Weather App");
		frmWeatherApp.setBounds(100, 100, 600, 400);
		frmWeatherApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWeatherApp.getContentPane().setLayout(null);
		
		txtCityName = new JTextField();
		txtCityName.setToolTipText("City Name");
		txtCityName.setBounds(10, 85, 149, 20);
		frmWeatherApp.getContentPane().add(txtCityName);
		txtCityName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Weather App");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 0, 584, 45);
		frmWeatherApp.getContentPane().add(lblNewLabel);
	}
}
