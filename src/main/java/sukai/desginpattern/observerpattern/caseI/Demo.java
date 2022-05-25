package sukai.desginpattern.observerpattern.caseI;

/**
 * @author chengsukai
 **/
public class Demo {
    public static void main(String[] args) {
        // create new Subject
        StockMarketChange stockMarketChange = new StockMarketChange();
        // create new Observer
        Client client = new Client();
        stockMarketChange.change();
        stockMarketChange.addPropertyChangeListener(client);
        stockMarketChange.change();
        //stockMarketChange.change();
        //stockMarketChange.change();
        //stockMarketChange.change();
    }
}