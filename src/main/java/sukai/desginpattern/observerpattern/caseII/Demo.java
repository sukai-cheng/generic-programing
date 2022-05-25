package sukai.desginpattern.observerpattern.caseII;

/**
 * @author chengsukai
 **/
public class Demo {

    public static void main(String[] args) {

        // create new Subject
        WeatherChange weatherChange = new WeatherChange();

        // create new Observer
        Query query = new Query();

        weatherChange.change();

        weatherChange.addPropertyChangeListener(query);

        weatherChange.change();


    }


}