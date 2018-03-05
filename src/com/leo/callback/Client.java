package com.leo.callback;

public class Client {

    private static int z = 0;
    public static void main(String[] args) {
        //ICalculate ic = new AddCal();
        int x = 3;
        int y = 4;
        //final int z = 0;
        Thread t = new Thread(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                
                Caller caller = new Caller(new ICalculate() {
                    
                    @Override
                    public int calcute() {
                        System.out.println("123");
                        z = x+y;
                        return z;
                    }
                });
                caller.processCal();
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("z="+z);
    }
}
