package Level2;

import java.util.Arrays;
import java.util.Scanner;

public class CardGame {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] arrA = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arrB = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = 0;

        for (int i = 0; i < 10; i++) {
            if (arrA[i] > arrB[i]) {
                result++;
            } else if (arrA[i] < arrB[i]) {
                result--;
            }
        }

        if (result > 0) {
            System.out.println("A");
        } else if (result < 0) {
            System.out.println("B");
        } else {
            System.out.println("D");
        }

    }

}
