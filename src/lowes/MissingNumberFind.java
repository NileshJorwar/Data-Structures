package src.lowes;

public class MissingNumberFind {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 6, 8};

        anotherApproach(arr);
        int xor = arr[0];

        // TODO: xor of all the numbers
        for (int i = 1; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        //TODO: xor of 1 to n+1
        int xor2 = 1;
        for (int i = 2; i <= arr.length + 1; i++) {
            xor2 = xor2 ^ i;
        }
        // TODO: xor of firstXor and SecordXor
        int m = xor ^ xor2;
        System.out.println(m);

    }

    public static void anotherApproach(int arr[]) {
        int first = arr[0];
        int newArr[] = new int[arr.length];
        newArr[0] = first;

        for (int i = 1; i < arr.length; i++) {
            int x = newArr[i - 1];
            newArr[i] = ++x;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != newArr[i]) {

                System.out.println(newArr[i]);
                break;
            }
        }

    }
}
