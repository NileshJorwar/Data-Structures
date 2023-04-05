package src.generics;

import java.util.Optional;

public class OptionalCreation {
    public static void main(String[] args) {

        String s = "A value";
        Optional<String> optional = Optional.of(s);
        Optional<Integer> em
                = Optional.empty();
        Optional<String> nullab = Optional.ofNullable(s);
        Optional<String> emptyOp = Optional.ofNullable(null);
        System.out.println();
        int x = 10;
        Optional<Integer> optionalInteger = Optional.of(x);
        Optional<Integer> optionalEmpty = Optional.empty();

        Integer x2 = optionalEmpty.isPresent() ? optionalEmpty.get(): 0;
        System.out.println(x2);

        Integer x3 = optionalEmpty.orElse(12);
        Integer x4 = optionalEmpty.orElseGet(()-> 13);
        System.out.println(x4);
        System.out.println(x3);
//        Integer x5 = optionalEmpty.orElseThrow(()->
//                new NumberFormatException("Exception"));
//        System.out.println(x5);
        Integer x6 = optionalEmpty.orElseThrow();
        System.out.println(x6);
    }
}
