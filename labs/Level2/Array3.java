package Level2;

import java.util.Scanner;

public class Array3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int firstNumber = 0;
        int indexNumber;

        for (int i = 1; i <= n; i++) {

            firstNumber += i;
            indexNumber = firstNumber;
            System.out.print(firstNumber + " ");

            for (int j = i; j < n; j++) {
                indexNumber += j;
                System.out.print(indexNumber + " ");
            }

            System.out.println();
        }

    }

}
