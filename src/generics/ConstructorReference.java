package src.generics;

import java.util.function.Function;

public class ConstructorReference {
    static int x;
    static int y;

    ConstructorReference(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {

        Function<Runnable, Thread> function =
                r -> new Thread(r);
        Function<Runnable, Thread> function2 =
                Thread::new;

        Function<Runnable, Thread> f = r -> new Thread(r);
        Function<Runnable, Thread> f2 = Thread::new;
        Runnable runnable = () -> System.out.println("Running thread");
        Thread t = f2.apply(runnable);
        t.start();
        f2.apply(()-> System.out.println("runs goooddd")).start();
    }
}
