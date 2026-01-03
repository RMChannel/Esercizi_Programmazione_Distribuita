/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package weatherclient;

/**
 *
 * @author Roberto
 */
public class WeatherClient {
    public static void main(String[] args) {
        System.out.println(weatherForecast("Salerno"));
        System.out.println(weatherForecast("Fisciano"));
        System.out.println(weatherForecast("Santa Maria a Vico"));
    }

    private static String weatherForecast(java.lang.String forecastPlace) {
        weather.WeatherForecast_Service service = new weather.WeatherForecast_Service();
        weather.WeatherForecast port = service.getWeatherForecastPort();
        return port.weatherForecast(forecastPlace);
    }
}
