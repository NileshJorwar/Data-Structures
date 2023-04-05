package src.functional;

public class LambdaExample {
    public static void main(String[] args) {
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);
//        thread.start();
        Thread thread = new Thread(
//                new Runnable() {
//            @Override
//            public void run()  {
//                System.out.println("Thread executed");
//            }
//        }
                () ->
                        System.out.println("Thread executed")

        );
        thread.start();
    }
}
