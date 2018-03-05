package com.leo.thread;

//死锁
public class ThreadTest7 {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        A aTh1 = new A(a,b);
        A aTh2 = new A(b,a);
        aTh1.start();
        aTh2.start();
    }
    
}
class A extends Thread {

    private Object a;
    private Object b;
    public A(Object a, Object b) {
        this.a=a;
        this.b=b;
    }
    @Override
    public void run() {
        synchronized (a) {
            System.out.println("get lock a from "+Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            synchronized (b) {
                System.out.println("get lock b from "+Thread.currentThread().getName());
            }
        }
        System.out.println("end");
    }
}
