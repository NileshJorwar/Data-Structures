package src.functional;

public class FunctionalGenericsDemo {
    public static void main(String[] args) {
        FunctionalGenerics<String, String> f1 =
                s-> s.substring(1,5);
        String f1R = f1.execute("NileshJo");
        System.out.println(f1R);

        FunctionalGenerics<String, Integer> f2 =
                s-> s.length();
        System.out.println(f2.execute("NileshJo"));

    }
}
