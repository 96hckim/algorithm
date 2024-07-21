package Level7;

import java.io.IOException;
import java.util.Scanner;

public class Mountain {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        printMountain(n);
    }

    private static void printMountain(int n) {
        if (n == 1) {
            System.out.print(1);
        } else {
            printMountain(n - 1);
            System.out.print(n);
            printMountain(n - 1);
        }

    }

}
