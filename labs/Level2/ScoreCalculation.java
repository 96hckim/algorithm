package Level2;

import java.util.Scanner;

public class ScoreCalculation {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int sum = 0;
        int extraPoints = 0;

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(scan.next()) == 1) {
                sum += 1 + extraPoints;
                extraPoints++;
            } else {
                extraPoints = 0;
            }
        }

        System.out.println(sum);

    }

}
