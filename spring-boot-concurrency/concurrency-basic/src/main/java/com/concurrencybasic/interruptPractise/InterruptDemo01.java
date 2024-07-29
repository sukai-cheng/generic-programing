package com.concurrencybasic.interruptPractise;

public class InterruptDemo01 {

    public static void main(String[] args) {
        Thread thread = new NormalThread();
        thread.start();
        try{
            Thread.sleep(500);
            thread.interrupt();
        }catch (InterruptedException e){
            System.out.println("Interrupted When Sleep");
            // 设置中断状态
            System.out.println(Thread.currentThread().isInterrupted());
        }
        Thread.yield();
    }


}

class NormalThread extends Thread {
    public void run() {
        super.run();
        for (int i = 0; i < 1000000000; i++) {
            if (this.isInterrupted()) {
                System.out.println("线程已经终止, for循环不再执行");
                return;
            }
            System.out.println("i=" + (i + 1));
        }
    }
}



