package publisher;

import org.json.simple.JSONObject;

public interface WeatherGenI {
	public double tempGen(String city);
	public String assumeWeather(double temp);
	public JSONObject getData(String _url);
}
