package src.functional;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {
    public static void main(String[] args) {
//        Consumer<Integer> consumer = i-> System.out.println(i);
        Consumer<Integer> consumer = System.out::println;
        consumer.accept(10);

//        Supplier<Integer> supplier = ()->"Nilesh".length();
        Supplier<Double> supplier = Math::random;
        System.out.println(supplier.get());

//        BiFunction<String, String, Integer> biFunction =
//                (x, y) -> AClass.staticTest(x, y);
        BiFunction<String, String, Integer> biFunction =
                AClass::staticTest;
        System.out.println(biFunction.apply("Sachin", "Nilesh"));

        Function<Runnable, Thread> threadFunction =
//                r -> new Thread(r);
                Thread::new;
        Runnable runnable =
                () -> System.out.println("Thread 1 running");
        Runnable runnable2 =
                () -> System.out.println("Thread 2 running");
        Thread thread = threadFunction.apply(runnable);
        Thread thread1 = threadFunction.apply(runnable2);

//        thread.start();
//        thread1.start();
        //Another way
        threadFunction.apply(()->System.out.println("Thread 1 running")).start();
        threadFunction.apply(()->System.out.println("Thread 2 running")).start();
    }
}

class AClass {
    public static int staticTest(String x, String y) {
        return (x + y).length();
    }
}
