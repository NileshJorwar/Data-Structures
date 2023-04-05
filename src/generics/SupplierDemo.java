package src.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierDemo {
    private static List<String> finalList = new ArrayList<>();

    public static void main(String[] args) {
        Supplier<String> stringSupplier =
                () -> "Hello";
//        Supplier<Integer> integerSupplier = ()-> "Nilesh".length();
        Supplier<Double> integerSupplier = Math:: random;

        System.out.println(stringSupplier.get());
        System.out.println(integerSupplier.get());
    }

}
