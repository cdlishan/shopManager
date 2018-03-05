package com.leo.thread;

//子线程循环10次，接着主线程循环100，接着回子线程循环10，主线程又100，反复50次
public class ThreadTest11 {

    public static void main(String[] args) {
        ThreadTest11 t = new ThreadTest11();
        ThreadPrint tp = t.new ThreadPrint();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    tp.printSub();
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            tp.pringMain();
        }
    }

    class ThreadPrint {
        private boolean flag = false;

        public synchronized void pringMain() {
            while (!flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("main thread run " + i);
            }
            flag = false;
            this.notify();

        }

        public synchronized void printSub() {
            while (flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("sub thread run " + i);
            }
            flag = true;
            this.notify();

        }
    }
}
