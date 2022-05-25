package sukai.desginpattern.observerpattern.caseII;

/**
 * @author chengsukai
 **/
public class WeatherData {
    private Double temperature; // 温度
    private Double humidity; // 湿度
    private Double pressure; // 气压

    public WeatherData() {
    }

    public WeatherData(Double temperature, Double humidity, Double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public WeatherData(WeatherData weatherData) {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }
}