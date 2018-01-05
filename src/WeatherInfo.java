
public class WeatherInfo {
    private String city;
    private String description;
    private int temperature;

    public WeatherInfo(String city, String description, int temperature) {
        this.city = city;
        this.description = description;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "\nWeatherInfo{" +
                "city = '" + city + '\'' +
                ", description = '" + description + '\'' +
                ", temperature = " + temperature +
                '}';
    }
}