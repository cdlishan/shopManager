package com.leo.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TRWTool {

    public static void main(String[] args) {
        readContent();
    }

    private static void readContent() {
        Thread t = new Thread(new Runnable() {
            
            @Override
            public void run() {
                
                FileInputStream fis = null;
                BufferedInputStream br = null;
                try {
                    File file = new File("c:\\SEP_INST.log");
                    //System.out.println(file.length());
                    //int byteread = 0;
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    br = new BufferedInputStream(new FileInputStream(file));
                    byte[] b = new byte[(int) file.length()];
                    //int tempchar =0;
                    long start = System.currentTimeMillis();
                    while ((br.read(b)) != -1 ) {
                        System.out.print(new String(b));
                    }
                    long end = System.currentTimeMillis();
                    System.out.println(end-start);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    try {
                        br.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }
}
