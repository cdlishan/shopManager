package com.leo.thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest3 {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();
    public static void main(String[] args)  {
        final ThreadTest3 test = new ThreadTest3();
         
        new Thread() {
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
         
        new Thread() {
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }  
     
    public void insert(Thread thread) {
        //Lock lock = new ReentrantLock();//局部变量，造成不同的线程拿到的是不同的锁，所以没有冲突
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁1");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
        } finally {
            System.out.println(thread.getName()+"释放了锁1");
            lock.unlock();
        }
    }
}
