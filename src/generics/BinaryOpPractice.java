package src.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;


public class BinaryOpPractice {
    public static void main(String[] args) {
        //BinaryOperator takes two same type params and returns same type
        BinaryOperator<String> binaryOperator =
                (a, b) -> a + "." + b;
        System.out.println(binaryOperator.apply("Basics", "Strong"));


    }
}
