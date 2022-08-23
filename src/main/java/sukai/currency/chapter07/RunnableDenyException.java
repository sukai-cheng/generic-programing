package sukai.currency.chapter07;

/**
 * @author chengsukai
 * @since 2022-08-23 20:06
 */
public class RunnableDenyException extends RuntimeException{
    public RunnableDenyException(String message){
        super(message);
    }
}
