package src.generics;

public class LambdaPractice1 {
    public static void main(String[] args) {

        Name name = () -> System.out.println("Nilesh");
        name.myName();
        //No need to specify types; as compiler understand type inference
        MathOperation mathOperation = (a, b) -> System.out.println(a + b);
        MathOperation mathOperation2 = (a, b) -> System.out.println(a * b);
        mathOperation.operation(10, 20);
        mathOperation2.operation(10, 20);

        StringLength stringLength = str -> str.length();
        int s = stringLength.len("nilesh");
        System.out.println(s);
        System.out.println("-------------");
        StringLength stringLength1 = str -> {
            System.out.println(str);
            return str.length();
        };

        int s2 = stringLength1.len("Sachin Balu");
        System.out.println(s2);



    }
}
