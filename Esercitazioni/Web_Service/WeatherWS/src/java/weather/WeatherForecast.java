/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package weather;

import jakarta.jws.*;
import java.util.Random;

/**
 *
 * @author Roberto
 */
@WebService(serviceName = "WeatherForecast")
public class WeatherForecast {
    @WebMethod(operationName="weather_forecast")
    public String forecast(@WebParam(name="forecast_place") String place) {
        if(place.equals("Salerno")) return "sun";
        else if(place.equals("Fisciano")) return "rain";
        else {
            Random r=new Random();
            if(r.nextBoolean()) return "sun";
            else return "rain";
        }
    }
}
