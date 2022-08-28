package sukai.currency.chapter12;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author chengsukai
 * @since 2022-08-27 11:20
 */
public class PhilosopherQuestion {
    @Data
    static class Philosopher {
        private int current;
        private Philosopher left;
        private Philosopher right;
        private int[] state;
        private int count;
        private Semaphore[] semaphores;
        private Semaphore mutex;

        public Philosopher(int current, int[] states, Semaphore[] semaphores, Semaphore mutex) {
            this.current = current;
            this.state = states;
            this.semaphores = semaphores;
            this.mutex = mutex;
        }

        public void think() throws InterruptedException {
            mutex.acquire();
            state[current] = 0;
            mutex.release();
        }

        public void takeForks() throws InterruptedException {
            mutex.acquire();
            state[current] = 1;
            testTakeForks(this);
            mutex.release();


        }

        private void testTakeForks(Philosopher p) throws InterruptedException {
            String time = new SimpleDateFormat("yyyy-MM-hh HH:mm:sss").format(new Date());
            if (state[p.current] == 1 && state[p.left.current] != 2 && state[p.right.current] != 2) {
                // 状态赋值为2 进入吃饭状态 表示拿到了两个叉子
                state[p.current] = 2;
                semaphores[p.current].release();
                System.out.println(time + "\t我是哲学家p" + current + "\t 第\t" + (++count) + "\t次拿到叉子" + "\t当前所有人状态：\t" + Arrays.toString(state));
            } else {
                // 两边的邻居有吃饭的，或者自己没有进入 进入饥饿状态的的，一定要记住，饥饿状态才是发起了抢叉子的请求！！！
                System.out.println(time + "\t我是哲学家p" + current + "\t 不具备拿叉子条件【我可能是被邻居唤醒检测】\t当前count:" + (count) + "\t当前所有人状态：\t" + Arrays.toString(state));
            }
        }

        private void eating() throws InterruptedException {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void putForks() throws InterruptedException {
            mutex.acquire();
            state[current] = 0;  // 放下了叉子
            testTakeForks(left); //
            testTakeForks(right);//
            mutex.release();
        }

        public void philosopherDay() {
            while (true) {
                try {
                    think();
                    takeForks();
                    eating();
                    putForks();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            // int THINKING = 0;  /* 思考*/     int HUNGRY = 1;   /*饥饿*/      int EATING = 2;    // 吃饭
            int count = 5;// 5个哲学家
            int[] state = new int[5];
            Semaphore[] semaphores = new Semaphore[5];  //索引关联  例如0编号哲学家 则对应semaphores[0]
            Semaphore mutex = new Semaphore(1);//设置可用令牌的初始数量，用于控制并发时同时获取资源权限的线程数量
            //所以哲学家 最开始都是思考状态
            for (int i = 0; i < 5; i++) {
                state[i] = 0;
            }
            // 索引下标对应 哲学家编号，归属哪个哲学家。
            for (int i = 0; i < 5; i++) {
                semaphores[i] = new Semaphore(0);

            }


            Philosopher p0 = new Philosopher(0, state, semaphores, mutex);
            Philosopher p1 = new Philosopher(1, state, semaphores, mutex);
            Philosopher p2 = new Philosopher(2, state, semaphores, mutex);
            Philosopher p3 = new Philosopher(3, state, semaphores, mutex);
            Philosopher p4 = new Philosopher(4, state, semaphores, mutex);


            p0.setLeft(p4);
            p0.setRight(p1);
            p1.setLeft(p0);
            p1.setRight(p2);
            p2.setLeft(p1);
            p2.setRight(p3);
            p3.setLeft(p2);
            p3.setRight(p4);
            p4.setLeft(p3);
            p4.setRight(p0);


            ExecutorService pool = Executors.newFixedThreadPool(5);
            pool.submit(p0::philosopherDay);
            pool.submit(p1::philosopherDay);
            pool.submit(p2::philosopherDay);
            pool.submit(p3::philosopherDay);
            pool.submit(p4::philosopherDay);


            Thread.sleep(100000);

        }
    }


}
