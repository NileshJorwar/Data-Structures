package src.generics;

public class AssertImpl {
    public static void main(String[] args) throws InterruptedException {

        AssertStat assertStat = () -> {
            System.out.println("testing");
            System.out.println("testing");
            System.out.println("testing");
        };
//        RetryAssert.retryAss(1000, ()->{
//            System.out.println("testing");
//            System.out.println("testing");
//            System.out.println("testing");
//            System.out.println("testing");
//        });
        RetryAssert.retryAss(1000, assertStat);

        AssertStat1 assertStat1 = (intVal)->{
            System.out.println("Printing"+ intVal + "Nil");
            System.out.println("Printing"+ intVal + "NS");
        };

        RetryAssert.retryAss2(1000, assertStat1, 100);
    }
}
