package src.generics;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {
    public static void main(String[] args) {
        //Imperative

        int sumEvn = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0)
                sumEvn += i;
        }
        System.out.println("Even:" + sumEvn);

        //Declarative or functional and thread safe
        int sum = IntStream.rangeClosed(0, 100)
                .filter(i -> i % 2 == 0)
                .reduce((x,y)->x+y)
                .getAsInt();
        System.out.println("SUm" + sum);
    }
}
