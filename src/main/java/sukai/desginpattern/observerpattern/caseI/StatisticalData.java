package sukai.desginpattern.observerpattern.caseI;

/**
 * @author chengsukai
 **/
public class StatisticalData {
    private double max;
    private double min;
    private double average;

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public StatisticalData() {
    }

    public StatisticalData(double max, double min, double average) {
        this.max = max;
        this.min = min;
        this.average = average;
    }

    public StatisticalData(StatisticalData statisticalData) {
        this.average = statisticalData.getAverage();
        this.max = statisticalData.getMax();
        this.min = statisticalData.getMin();
    }

    @Override
    public String toString() {
        return "StatisticalData{" +
                "max=" + max +
                ", min=" + min +
                ", average=" + average +
                '}';
    }
}










































