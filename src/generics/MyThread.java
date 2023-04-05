package src.generics;

public class MyThread implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread executed");
    }
}
