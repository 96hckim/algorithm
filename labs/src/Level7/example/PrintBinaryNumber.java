package Level7.example;

import java.util.Scanner;

/**
 * 10진수 n의 2진수 출력
 */
public class PrintBinaryNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        printBinaryNumber(n);
    }

    private static void printBinaryNumber(int n) {
        if (n < 2) {
            System.out.print(n);
        } else {
            printBinaryNumber(n / 2);
            System.out.print(n % 2);
        }
    }

}
