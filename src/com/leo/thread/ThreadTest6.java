package com.leo.thread;

public class ThreadTest6 {

    public static void main(String[] args) {
        RunThread th = new RunThread();
        th.start();
        try {
            th.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        th.setFlag(true);
        System.out.println("设置flag为true");
    }
}

class RunThread extends Thread {
    volatile private boolean flag = false;

   

    public boolean isFlag() {
        return flag;
    }



    public void setFlag(boolean flag) {
        this.flag = flag;
    }



    @Override
    public void run() {
        System.out.println("开始线程");
        while(!flag) {
            //System.out.println("flag = "+flag);
        }
        System.out.println("停止线程");
    }

    
}