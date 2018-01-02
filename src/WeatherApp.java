import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherApp {
    public static void main(String[] args) throws IOException {

        List<WeatherInfo> citiesWeatherInfo = new ArrayList<>();
        FileReader fr = new FileReader("cities.txt");
        BufferedReader br = new BufferedReader(fr);
        WeatherApi weatherApi = new WeatherApi();
        String city = null;
        while ((city = br.readLine()) != null) {
            WeatherInfo wi = new WeatherInfo(city, weatherApi.getDescription(city), weatherApi.getTemperature(city));
            citiesWeatherInfo.add(wi);
        }
        br.close();

        System.out.println(citiesWeatherInfo);

        FileOutputStream fos = new FileOutputStream("weatherInfo.csv");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Object info : citiesWeatherInfo) {
            oos.writeObject(info);
        }
    }
}