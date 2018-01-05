import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherApp {
    public static void main(String[] args) throws IOException {

        List<WeatherInfo> citiesWeatherInfo = new ArrayList<>();
        FileReader fileReader = new FileReader("cities.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        WeatherApi weatherApi = new WeatherApi();
        String city = null;

        FileWriter fw = new FileWriter("weatherInfo.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        while ((city = bufferedReader.readLine()) != null) {
            WeatherInfo wi = new WeatherInfo(city, weatherApi.getDescription(city), weatherApi.getTemperature(city));
            citiesWeatherInfo.add(wi);
            bufferedWriter.write("\n" + city + ";" + weatherApi.getTemperature(city) + ";" + weatherApi.getDescription(city));
        }
        bufferedReader.close();
        bufferedWriter.close();

        System.out.println(citiesWeatherInfo);
    }
}