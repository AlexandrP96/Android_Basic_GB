package com.weathergb.winfo;

public class WeatherRequest {

    private Weather[] weather;
    private Main main;
    private Wind wind;
    private Clouds cloud;
    private String name;

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getCloud() {
        return cloud;
    }

    public void setCloud(Clouds cloud) {
        this.cloud = cloud;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
