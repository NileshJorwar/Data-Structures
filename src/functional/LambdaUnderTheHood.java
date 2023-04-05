package src.functional;

public class LambdaUnderTheHood {
    public static void main(String[] args) {
        MyFunInterface myFunInterface = new MyFunInterface() {
            public void myMethod() {
                System.out.println("Hello");
            }
        };
        MyFunInterface myFunInterface2 = new MyFunInterface() {
            public void myMethod() {
                System.out.println("Hello2");
            }
        };

        MyFunInterface myFunInterface3 = ()-> System.out.println("Using lambda");
        myFunInterface3.myMethod();


        }

}
