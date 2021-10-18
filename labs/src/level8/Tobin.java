package level8;

import java.util.Scanner;

public class Tobin {

    private static int[] result;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        result = new int[n];

        printBinary(0, n, k);

    }

    private static void printBinary(int x, int n, int k) {

        if (x >= n) {
            if (k <= 0) {
                for (int num : result) {
                    System.out.print(num);
                }
                System.out.println();
            }
        } else {
            for (int i = 1; i >= 0; i--) {
                result[x] = i;
                if (i == 1 && k > 0) {
                    printBinary(x + 1, n, k - 1);
                } else if (i == 0) {
                    printBinary(x + 1, n, k);
                }
            }
        }

    }

}
