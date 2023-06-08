package src.multithreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("We are now in : " + Thread.currentThread().getId());
            }
        });
//        Thread thread = new Thread(() ->
//                System.out.println("We are now in : " + Thread.currentThread().getName())
//
//        );
        thread.setName("Worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Before thread: " + Thread.currentThread().getName());
        thread.start();
        System.out.println("After thread: " + Thread.currentThread().getName());

//        Thread.sleep(10000);

    }
}
