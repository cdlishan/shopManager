package com.leo.thread;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		Thread t1 = new ThreadPrint("A",c,a);
		Thread.sleep(100);
		Thread t2 = new ThreadPrint("B",a,b);
		Thread.sleep(100);
		Thread t3 = new ThreadPrint("C",b,c);
		Thread.sleep(100);
		t1.start();
		t2.start();
		t3.start();
		
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
