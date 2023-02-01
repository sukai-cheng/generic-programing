package com.designpattern.observerpattern.caseII;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author chengsukai
 **/
public class WeatherChange {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private WeatherData weatherData;
    private List<Double> temperature; // 温度
    private List<Double> humidity; // 湿度
    private List<Double> pressure; // 气压

    /**
     * 初始化数据
     */
    public WeatherChange() {
        this.temperature = new ArrayList<>();
        this.humidity = new ArrayList<>();
        this.pressure = new ArrayList<>();

        Random random = new Random();
        this.temperature.add(random.nextDouble() * 100);
        this.humidity.add(random.nextDouble() * 100);
        this.pressure.add(random.nextDouble() * 100);

        this.weatherData = new WeatherData(getNewTemperature(), getNewHumidity(), getNewPressure());
    }


    /**
     * 更新温度数据
     *
     * @return void
     */
    private void changeNewTemperature() {

        Random random = new Random();

        double newTemperature = random.nextDouble() * 100;

        double oldTemperature = this.temperature.get(this.temperature.size() - 1);

        this.temperature.add(newTemperature);

        firePropertyChange("温度数据发生变化", oldTemperature, newTemperature);
    }

    /**
     * 更新湿度数据
     *
     * @return void
     */
    private void changeNewHumidity() {
        Random random = new Random();

        double newHumidity = random.nextDouble() * 100;

        double oldHumidity = this.temperature.get(this.humidity.size() - 1);

        this.temperature.add(newHumidity);

        firePropertyChange("湿度数据发生变化", oldHumidity, newHumidity);
    }


    /**
     * 更新气压数据
     *
     * @return void
     */
    private void changeNewPressure() {
        Random random = new Random();

        double newPressure = random.nextDouble() * 100;

        double oldPressure = this.pressure.get(this.humidity.size() - 1);

        this.pressure.add(newPressure);

        firePropertyChange("气压数据发生变化", oldPressure, newPressure);
    }

    /**
     * 更新天气报告
     *
     * @return void
     */
    private void updateWeatherData() {
        if (this.pressure.size() > 1 || this.humidity.size() > 1 || this.temperature.size() > 1) {
            WeatherData oldWeatherData = new WeatherData(this.weatherData);
            WeatherData newWeatherData = this.weatherData;
            newWeatherData.setHumidity(getNewHumidity());
            newWeatherData.setPressure(getNewPressure());
            newWeatherData.setTemperature(getNewTemperature());
            firePropertyChange("天气数据发生变化", oldWeatherData, newWeatherData);
        }
    }

    /**
     * 天气情况趋势
     * @return java.util.Map<java.lang.String, java.lang.Double>
     * @create 2022/5/25 3:19 PM
     * @author chengsukai
     */
    private void getTendency(WeatherData weatherData) {

        Map<String, Double> map = new HashMap<>();

        double newTemperature = getNewTemperature();
        double newHumidity = getNewHumidity();
        double newPressure = getNewPressure();

        if (weatherData.getTemperature() > newTemperature) {
            map.put("温度上升", newTemperature);
        } else if (weatherData.getTemperature() < newTemperature) {
            map.put("温度下降", newTemperature);
        }

        if (weatherData.getHumidity() > newHumidity) {
            map.put("湿度上升", newHumidity);
        } else if (weatherData.getHumidity() < newHumidity) {
            map.put("湿度下降", newHumidity);
        }

        if (weatherData.getPressure() > newPressure) {
            map.put("气压上升", newPressure);
        } else if (weatherData.getTemperature() < newPressure) {
            map.put("气压下降", newPressure);
        }

        for (Map.Entry<String,Double> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }




    /**
     * 控制天气变化的函数
     * @return void
     * @create 2022/5/25 3:04 PM
     * @author chengsukai
     */
    public void change() {
        changeNewTemperature();
        changeNewHumidity();
        changeNewPressure();
    }

    /**
     * 获取最新的温度
     *
     * @return double
     */
    public double getNewTemperature() {
        return temperature.get(temperature.size() - 1);
    }

    /**
     * 获取最新的湿度
     *
     * @return double
     */
    public double getNewHumidity() {
        return humidity.get(humidity.size() - 1);
    }

    /**
     * 获取最新的气压
     *
     * @return double
     */
    public double getNewPressure() {
        return pressure.get(pressure.size() - 1);
    }

    /**
     * 添加监听者
     *
     * @param listener
     *         监听者
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    /**
     * 通知监听者
     *
     * @param propName
     *         给改变一个名字，好让监听者们根据这个名字来做响应
     * @param oldValue
     *         改变前的值
     * @param newValue
     *         改变后的值
     */
    public void firePropertyChange(String propName, Object oldValue, Object newValue) {
        this.pcs.firePropertyChange(propName, oldValue, newValue);
    }

    /**
     * 删除监听者
     *
     * @param listener
     *         监听者
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "WeatherChange{" +
                "pcs=" + pcs +
                ", weatherData=" + weatherData +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public PropertyChangeSupport getPcs() {
        return pcs;
    }

    public List<Double> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<Double> temperature) {
        this.temperature = temperature;
    }

    public List<Double> getHumidity() {
        return humidity;
    }

    public void setHumidity(List<Double> humidity) {
        this.humidity = humidity;
    }

    public List<Double> getPressure() {
        return pressure;
    }

    public void setPressure(List<Double> pressure) {
        this.pressure = pressure;
    }
}