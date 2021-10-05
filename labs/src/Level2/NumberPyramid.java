package Level2;

import java.util.Scanner;

public class NumberPyramid {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.next());
        int s = Integer.parseInt(scan.next());

        int startNumber = s;
        int endNumber = s;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            if (i == 1) {
                System.out.println(s);
                continue;
            }

            int startCursor;

            if (i % 2 == 0) {
                startCursor = startNumber + 1;
                if (startCursor == 10) startCursor = 1;

                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print(startCursor++);
                    if (startCursor == 10) startCursor = 1;
                }

                endNumber = startCursor;
            } else {
                startCursor = endNumber - 1;
                for (int j = 0; j < 2 * i - 1; j++) {
                    startCursor++;
                    if (startCursor == 10) startCursor = 1;
                }

                startNumber = startCursor;

                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print(startCursor--);
                    if (startCursor == 0) startCursor = 9;
                }
            }

            System.out.println();
        }

    }

}
