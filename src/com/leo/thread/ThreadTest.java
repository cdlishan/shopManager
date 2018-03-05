package com.leo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
//        Object a = new Object();
//        Object b = new Object();
//        Object c = new Object();
//        Thread t1 = new ThreadPrint("A",c,a);
//        t1.start();
//        Thread.sleep(50);
//        Thread t2 = new ThreadPrint("B",a,b);
//        t2.start();
//        Thread.sleep(50);
//        Thread t3 = new ThreadPrint("C",b,c);
//        t3.start();
        
        ThreadPrint2 task = new ThreadPrint2();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        thread1.setName("A");
        thread2.setName("B");
        thread3.setName("C");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
class ThreadPrint extends Thread {

    private static int count =10;
    Object prev;
    Object next;
    String name;
    
    public ThreadPrint(String name,Object prev, Object next) {
        this.prev = prev;
        this.next = next;
        this.name = name;
    }

    @Override
    public void run() {
        int count = 10;
        while(count>0) {
            synchronized (prev) {
                synchronized (next) {
                    System.out.print(name);
                    count--;
                    next.notify();
                }     
                try {
                    prev.wait();     
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
class ThreadPrint2 extends Thread {

    int state = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition c = lock.newCondition();
    int printNum = 1;
    @Override
    public void run() {
        lock.lock();
        int count = 10;
        try {
            while (count>0) {
                if(Thread.currentThread().getName().equals("A")) {
                    while(state%3!=0) {
                        c.await();
                    }
                } else if(Thread.currentThread().getName().equals("B")) {
                    while(state%3!=1) {
                        c.await();
                    }
                } else if(Thread.currentThread().getName().equals("C")) {
                    while(state%3!=2) {
                        c.await();
                    }
                }
                count--;
                state++;
                /*for(int i =0;i<5;i++) {
                    if (printNum>75) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+","+printNum);
                    printNum++;
                }*/
                System.out.print(Thread.currentThread().getName());
                c.signalAll();
                
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
}
