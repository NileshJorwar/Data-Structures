package src.generics;

public class FunctionalGenericsDemo {
    public static void main(String[] args) {

        FunctionalGenerics<String, String> functionalGenerics = str -> str + "Nilesh";
        FunctionalGenerics<String, String> functionalGenerics2 = str -> str.substring(1, 5);
        String r = functionalGenerics.execute("Sachin ");
        String r1 = functionalGenerics2.execute("Sachin");
        System.out.println(r);
        System.out.println(r1);

        FunctionalGenerics<Integer, String> integerStringFunctionalGenerics =
                i -> {
                    String n = i + " added";
                    return n;
                };
        String s = integerStringFunctionalGenerics.execute(10);
        System.out.println(s);
    }
}
