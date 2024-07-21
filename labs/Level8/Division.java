package Level8;

import java.util.ArrayList;
import java.util.Scanner;

public class Division {

    private static int n;
    private static int resultCount = 0;
    private static ArrayList<Integer> divisionNumbers = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        printDivision(0, n - 1);
        System.out.println(resultCount);

    }

    private static void printDivision(int sum, int num) {

        if (sum == n) {
            resultCount++;

            System.out.print(divisionNumbers.get(0));
            for (int i = 1; i < divisionNumbers.size(); i++) {
                System.out.print("+" + divisionNumbers.get(i));
            }
            System.out.println();
        }

        for (int i = num; i >= 1; i--) {
            sum += i;
            if (sum <= n) {
                divisionNumbers.add(i);
                printDivision(sum, i);
                divisionNumbers.remove(divisionNumbers.size() - 1);
            }
            sum -= i;
        }

    }

}
