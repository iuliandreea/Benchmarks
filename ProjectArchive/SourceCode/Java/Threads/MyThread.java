package Threads;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {

    public Semaphore s1, s2;

    public MyThread(Semaphore s1, Semaphore s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run(){
        try{
            s1.acquire();
            s2.release();

            s1.acquire();
            s2.release();
        }catch(Exception e){
        }
    }
}
