package level8;

import java.util.ArrayList;
import java.util.Scanner;

public class Inequal {

    private static int k;
    private static ArrayList<String> inequalList = new ArrayList<>();
    private static boolean[] useNumberCheck = new boolean[10];
    private static ArrayList<String> resultList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int k = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < k; i++) {
            inequalList.add(scan.next());
        }

        allTrue(new int[k + 1], 0);
        System.out.println(resultList.get(resultList.size() - 1));
        System.out.println(resultList.get(0));

    }

    private static void allTrue(int[] arr, int n) {

        if (n >= arr.length) {

            boolean isPossible = true;
            for (int i = 0; i < inequalList.size(); i++) {
                if (inequalList.get(i).equals(">")) {
                    if (arr[i] < arr[i + 1]) {
                        isPossible = false;
                        break;
                    }
                } else {
                    if (arr[i] > arr[i + 1]) {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) {
                StringBuilder result = new StringBuilder();

                for (int num : arr) {
                    result.append(num);
                }

                resultList.add(result.toString());
            }

        } else {

            for (int i = 0; i < useNumberCheck.length; i++) {
                if (!useNumberCheck[i]) {
                    useNumberCheck[i] = true;
                    arr[n] = i;
                    allTrue(arr, n + 1);
                    useNumberCheck[i] = false;
                }
            }

        }

    }

}
