package com.leo.thread;

public class ThreadTest10 {

    //现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread t1 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("t1");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("t2");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("t3");
            }
        });
        t1.start();
        t2.start();
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("main thread end");
    }

}
