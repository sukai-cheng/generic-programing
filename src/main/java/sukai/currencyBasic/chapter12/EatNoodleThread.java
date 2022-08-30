package sukai.currencyBasic.chapter12;

/**
 * @author chengsukai
 * @since 2022-08-26 15:20
 */
public class EatNoodleThread extends Thread {
    private final String name;

    private TablewarePair tablewarePair;

    public EatNoodleThread(String name, TablewarePair tablewarePair) {
        this.name = name;
        this.tablewarePair = tablewarePair;
    }

    public void eat() {
        synchronized (tablewarePair) {
            System.out.println(name + " take up " + tablewarePair.getLeftTool() + "(left)");
            synchronized (tablewarePair.getRightTool()) {
                System.out.println(name + " take up " + tablewarePair.getRightTool() + "(right)");
                System.out.println(name + " is eating now");
                System.out.println(name + " put down " + tablewarePair.getRightTool() + "(right)");
            }
            System.out.println(name + " put down " + tablewarePair.getLeftTool() + "(left)");
        }
    }

    @Override
    public void run() {

        while (true) {
            this.eat();
        }

    }

    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        TablewarePair tools = new TablewarePair(fork, knife);
        new EatNoodleThread("A", tools).start();
        new EatNoodleThread("B", tools).start();
    }
}
