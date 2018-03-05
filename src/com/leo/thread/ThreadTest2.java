package com.leo.thread;

import java.util.concurrent.CountDownLatch;

public class ThreadTest2 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cl = new CountDownLatch(5);
        Counter counter = new Counter(cl);
        Thread t1 = new Thread(counter,"t1");
        Thread t2 = new Thread(counter,"t2");
        Thread t3 = new Thread(counter,"t3");
        Thread t4 = new Thread(counter,"t4");
        Thread t5 = new Thread(counter,"t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        cl.await();
        System.out.println("end");
    }

    
}
class Counter implements Runnable {

    CountDownLatch cl;
    int count = 5;
    
    public Counter(CountDownLatch cl) {
        this.cl= cl;
    }

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName()+" execute operation "+count);
        count--;
        cl.countDown();
    }
}
