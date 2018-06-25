package com.leo.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        //子线程1次await
        Thread t =
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            c.await();
                        } catch (Exception e) {

                        }
                        System.out.println(1);
                    }
                });
        t.start();
        //主线程一次await
        try {
            c.await();
        } catch (Exception e) {

        }
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
