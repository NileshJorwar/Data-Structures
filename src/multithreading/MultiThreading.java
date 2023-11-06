package src.multithreading;

import com.sun.security.jgss.GSSUtil;

public class MultiThreading {
    public static void main(String[] args) {
        //One way to create a thread
        Thread thread = new Thread(
                () ->
                        System.out.println("Thread running in my local")
        );

        thread.start();

        Thread newThread = new NewThread();
        newThread.isAlive();
    }

    public static class NewThread extends Thread{
        @Override
        public void run(){
            System.out.println("in separate thread class");
        }
    }
}
