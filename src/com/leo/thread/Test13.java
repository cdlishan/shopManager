package com.leo.thread;

public class Test13 {
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

class MyObject extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : "
                + SingleTon.getInstance().hashCode());
    }

}

class SingleTon {

    private static SingleTon s;

    private SingleTon() {

    }

    public static SingleTon getInstance() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (s == null) {
            synchronized (SingleTon.class) {
                if (s == null) {
                    s = new SingleTon();
                }
            }
        }

        return s;
    }
}