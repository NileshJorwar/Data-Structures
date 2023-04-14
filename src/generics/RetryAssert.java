package src.generics;

public class RetryAssert {
    public static void retryAss(int wait, AssertStat assertStat) throws InterruptedException {
        int count = 0;
        boolean assertFlag = true;
        while (assertFlag) {
            try {
                Thread.sleep(wait);
                assertStat.execute();
                assertFlag = false;
                count++;
            } catch (InterruptedException  e) {
                if (count == 5) {
                    throw e;
                }
                System.out.printf("");
            }
        }
    }

    public static void retryAss2(int wait, AssertStat1 assertStat1, int intVal) throws InterruptedException {
        int count = 0;
        boolean assertFlag = true;
        while (assertFlag) {
            try {
                Thread.sleep(wait);
                assertStat1.execute(100);
                assertFlag = false;
                count++;
            } catch (InterruptedException  e) {
                if (count == 5) {
                    throw e;
                }
                System.out.printf("");
            }
        }
    }
}
