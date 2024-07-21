package Level2;

import java.util.Scanner;

public class Array1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.next());
        int m = Integer.parseInt(scan.next());

        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(++num + " ");
            }
            System.out.println();
        }

    }

}
