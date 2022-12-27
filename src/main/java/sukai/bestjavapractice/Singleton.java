package sukai.bestjavapractice;

/**
 * @author chengsukai
 * @since 2022-12-27 12:28
 */
public class Singleton {
    private Singleton instance;

    public Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    private Singleton(){}
}
