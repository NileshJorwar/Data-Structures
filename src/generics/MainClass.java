package src.generics;

public class MainClass {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread);
//        thread.start();

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread executed again");
//            }
//        });
//        thread.start();

        //Using lambda
        // we can remove  new Runnable() bcz compiler knows Thread accepts
        // Runnable interface and can remove public access modifier bcz method should
        // always be public, can also remove name of method as compiler knows runnable has only method and hence can guess it
        // and after java 8, can remove return type as compiler know type reference
        // body contains single statement, hence remove curly brackets too inside run()
        Thread thread = new Thread(
//                ()-> {
//                    System.out.println("Lambda thread executes");
//                }
                () -> System.out.println("Lambda thread executes")

        );
        thread.start();

    }
}
