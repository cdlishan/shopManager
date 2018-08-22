package com.leo.thread;

import java.util.concurrent.CountDownLatch;

public class ThreadTest9 {
    //证明volatile不是原子操作
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CountDownLatch cl = new CountDownLatch(1000);
        VolatileTest vt = new VolatileTest(cl);
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    vt.setCount();
                }
            }).start();
        }
        //保证1000个子线程运行完，主线程再结束
        /*while(Thread.activeCount()>1)
        {
            Thread.yield();
        }*/
        try {
            cl.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();long a = System.currentTimeMillis();
        }
        System.out.println(vt.getCount());
    }

}

class VolatileTest {
    volatile private int count = 0;
    CountDownLatch cl;

    public VolatileTest(CountDownLatch cl) {
        this.cl = cl;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        synchronized (this) {
            this.count++;
        }
        //this.count++;
        cl.countDown();
    }
}
