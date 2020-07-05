package publisher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeatherGenImpl implements WeatherGenI {
	private static WeatherGenI tg;

	/*
	 * (non-Javadoc)
	 * 
	 * @see publisher.tempGenI#tempGen()
	 *
	 * TODO : change method implementation to generate random values.
	 */
	@Override
	public double tempGen(String city) {
		Random rand = new Random();
		if (city.equalsIgnoreCase("colombo")) {
			int temp;
			while (true) {
				temp = rand.nextInt();
				if (temp >= 25 && temp < 29) {
					return temp;
				}
			}
		} else if (city.equalsIgnoreCase("Jaffna")) {
			int temp;
			while (true) {
				temp = rand.nextInt();
				if (temp >= 29 && temp < 33) {
					return temp;
				}
			}
		} else {
			return 0;
		}
	}

	@Override
	public String assumeWeather(double temp) {

		if (temp >= 25 && temp < 27) {
			return "Windy";
		}

		else if (temp >= 27 && temp < 29) {
			return "Rainy";
		}

		else if (temp >= 29 && temp <= 31) {
			return "Cloudy";
		}

		else if (temp > 31 && temp <= 33) {
			return "Sunny";
		}

		else {
			return null;
		}

	}

	public static WeatherGenI getInstance() {
		if (tg == null) {
			tg = new WeatherGenImpl();
		}

		return tg;
	}

	@Override
	public JSONObject getData(String _url) {
		URL url;
		JSONObject obj = null;
		try {
			url = new URL(_url);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("GET");
			httpCon.setRequestProperty("Accept", "application/json");

			if (httpCon.getResponseCode() != 200) {
				throw new RuntimeException("HTPP error code: " + httpCon.getResponseCode());
			}

			BufferedReader buffR = new BufferedReader(new InputStreamReader((httpCon.getInputStream())));
			obj = (JSONObject) new JSONParser().parse(buffR);

			httpCon.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}
}
