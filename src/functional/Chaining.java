package src.functional;

public class Chaining {
    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = s -> System.out.println(s);

        c1.accept("Hello");
        c2.accept("Hello");

        Consumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };

        c3.accept("Sachin");
        Consumer<String> c4 = c1.thenAccept(c2);
        c4.accept("Nilesh");
    }
}

@FunctionalInterface
interface Consumer<T> {

    void accept(T t);

    default Consumer<T> thenAccept(Consumer<T> next) {
        return (T t) -> {
            this.accept(t);
            next.accept(t);
        };
    }

}
