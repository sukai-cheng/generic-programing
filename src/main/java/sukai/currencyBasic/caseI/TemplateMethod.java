package sukai.currencyBasic.caseI;

/**
 * @description 程序控制由父类实现， 子类只需要实现想要的逻辑
 *
 * @author chengsukai
 *
 * @create 2022-04-20 07:11
 **/
public class TemplateMethod {

    public final void print(String message){
        System.out.println("##########start###########");
        wrapPrint(message);
        System.out.println("##########stop###########");
    }

    public void wrapPrint(String message){

    }

    public static void main(String[] args) {
        TemplateMethod tm = new TemplateMethod(){
            @Override
            public void wrapPrint(String message) {
                System.out.println("*" + message + "*");
            }
        };

        tm.print("TaskA");
    }
}