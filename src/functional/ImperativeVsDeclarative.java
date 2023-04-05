package src.functional;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {
    public static void main(String[] args) {
        //Imperative
        int sumOfEvens = 0;
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 0)
//                sumOfEvens = sumOfEvens + i;
//        }

        //Declarative
        sumOfEvens = IntStream.range(0, 100).filter(i -> i % 2 == 0).reduce((x, y) -> x + y).getAsInt();
        System.out.println(sumOfEvens);


        MathOp  mathOp = (a,b)-> System.out.println(a+b);
        mathOp.operation(10,22);
        MathOp  mathOp1 = (a,b)-> System.out.println(a*b);
        mathOp1.operation(10,22);
        MathOp2  mathOp2 = (str)-> {
            int l = str.length();
            System.out.println("Length is : "+l);
            return l;};
        int x = mathOp2.length("SACHIN");
//        System.out.println(x);
    }
}
@FunctionalInterface
interface MathOp{
    public void operation(int a, int b);
}

@FunctionalInterface
interface MathOp2{
    public int length(String s);
}
