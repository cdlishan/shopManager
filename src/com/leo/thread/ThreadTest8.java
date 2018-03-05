package com.leo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadTest8 {

    public static void main(String[] args) {
        final BlockingQueue<String> bq = new ArrayBlockingQueue<String>(2);
        Runnable producerRunnable = new Runnable()
        {
            int i = 0;
            public void run()
            {
                while (true)
                {
                    try
                    {
                        System.out.println("我生产了一个" + i++);
                        bq.put(i + "");
                        System.out.println("生产bq.size()=="+bq.size());
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable customerRunnable = new Runnable()
        {
            public void run()
            {
                while (true)
                {
                    try
                    {
                        System.out.println("消费bq.size()=="+bq.size());
                        System.out.println("我消费了一个" + bq.take());
                        Thread.sleep(3000);
                    } 
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread producerThread = new Thread(producerRunnable);
        Thread customerThread = new Thread(customerRunnable);
        producerThread.start();
        customerThread.start();
    }

}
class PCFactory {
    BlockingQueue<Object> list = new LinkedBlockingQueue<Object>(1);
    
    public void get() {
        try {
            list.take();
            System.out.println("get");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void put() {
        try {
            list.put(new Object());
            System.out.println("put");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}