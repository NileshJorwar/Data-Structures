package src.patterns;

/*
 *  *
 *  * *
 *  * * *
 *  * * * *
 * */
public class StarPattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("*****************");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }

        System.out.println("*****************");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((i + 1) + " ");
            }
            System.out.println();
        }

        System.out.println("*****************");
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }

        System.out.println("*****************");
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("*****************");
        int count = 0;
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= count; k++) {
                System.out.print("*");
            }
            for (int k = 0; k <= count; k++) {
                System.out.print("*");
            }
            System.out.println();
            count++;
        }
        System.out.println("*****************");
        int xor = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                xor = xor ^ 1;
                System.out.print(xor + " ");
            }
            System.out.println();
        }
    }
}
