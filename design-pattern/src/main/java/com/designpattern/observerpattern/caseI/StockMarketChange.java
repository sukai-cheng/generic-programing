package com.designpattern.observerpattern.caseI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author chengsukai
 **/
public class StockMarketChange {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private final List<Double> price;
    private boolean tendency;
    private final StatisticalData statisticalData;

    /**
     * 股市初始化
     */
    public StockMarketChange() {
        this.price = new ArrayList<>();
        Random random = new Random();
        this.price.add((double) random.nextFloat() * 100);
        //更新趋势预测
        int number = random.nextInt(2);
        this.tendency = number == 1;

        this.statisticalData = new StatisticalData(getNewPrice(), getNewPrice(), getNewPrice());
    }

    /**
     * 让股市价格变化并更新价格
     */
    private void changeNewPrice() {
        Random random = new Random();
        //改变后的值
        double newPrice = (double) random.nextFloat() * 100;

        //改变前的值
        double oldPrice = this.price.get(this.price.size() - 1);

        //添加改变的值
        this.price.add(newPrice);

        // 具体是哪个数据发生变化相当于Observable接口中的update()方法
        firePropertyChange("股市价格发生变动", oldPrice, newPrice);
    }

    /**
     * 更新趋势预测
     */
    private void updateTendency() {
        if (this.price.size() > 1) {
            double newPrice = this.price.get(this.price.size() - 1);
            double oldPrice = this.price.get(this.price.size() - 2);
            String oldTendency = getTendency();
            this.tendency = newPrice >= oldPrice;
            String newTendency = getTendency();
            if (!newTendency.equals(oldTendency)) {
                firePropertyChange("股市趋势预测发生变动", oldTendency, newTendency);
            }
        }
    }

    /**
     * 更新统计分析报告
     */
    private void updateStatisticalData() {
        if (this.price.size() > 1) {
            StatisticalData oldStatisticalData = new StatisticalData(this.statisticalData);
            StatisticalData newStatisticalData = this.statisticalData;
            double max = Collections.max(this.price);
            double min = Collections.min(this.price);
            double average = 0;
            for (Double aDouble : this.price) {
                average = average + aDouble;
            }
            average = average / this.price.size();
            newStatisticalData.setAverage(average);
            newStatisticalData.setMax(max);
            newStatisticalData.setMin(min);
            firePropertyChange("统计分析报告发生变动", oldStatisticalData, newStatisticalData);
        }
    }

    /**
     * 控制股市变化的函数
     */
    public void change() {
        changeNewPrice();
        updateTendency();
        updateStatisticalData();
    }

    /**
     * 获得趋势预测情况
     */
    public String getTendency() {
        if (this.tendency) {
            return "股市价格将上涨";
        } else {
            return "股市价格将下跌";
        }
    }

    /**
     * 获得统计分析报告
     */
    public StatisticalData getStatisticalData() {
        return statisticalData;
    }

    /**
     * 获取股市最新价格
     */
    public double getNewPrice() {
        return price.get(price.size() - 1);
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

    /**
     * 打印用的方法
     */
    @Override
    public String toString() {
        return "Stock{" +
                "price=" + price +
                ", tendency=" + tendency +
                ", statisticalData=" + statisticalData +
                '}';
    }

}