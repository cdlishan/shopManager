package com.leo.thread;

import java.util.concurrent.CountDownLatch;

public class ThreadTest12 {
    public static void main(String[] args) {
        CountDownLatch c = new CountDownLatch(4);
        DataShare data = new DataShare(c);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                data.addShare();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                data.addShare();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                data.subShare();
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                data.subShare();
            }
        });
        t1.setName("add share 1");
        t2.setName("add share 2");
        t3.setName("sub share 1");
        t4.setName("sub share 2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            c.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("share = " + data.getShare());
    }
}

class DataShare {

    int share = 0;
    CountDownLatch c;

    public int getShare() {
        return share;
    }

    public DataShare(CountDownLatch c) {
        this.c = c;
    }

    public synchronized void addShare() {
        share++;
        System.out.println("share ++ by" + Thread.currentThread().getName());
        c.countDown();
    }

    public synchronized void subShare() {
        share--;
        System.out.println("share -- by" + Thread.currentThread().getName());
        c.countDown();
    }
}
