package Level14.example;

import java.io.IOException;

/**
 * 완전 탐색 (합부분 줄임) n^2
 */
public class ConsecutivePartialMaximum2 {

    public static void main(String[] args) throws IOException {

        int[] arr = {1, 2, -4, 5, 3, -2, 9, 10};

        int[] sumArr = new int[arr.length];
        sumArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sumArr[i] = arr[i] + sumArr[i - 1];
        }

        int max = sumArr[0];
        int startIndex = 0;
        int endIndex = 0;

        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {

                int sum;

                if (start == 0) sum = sumArr[end];
                else sum = sumArr[end] - sumArr[start - 1];

                if (sum > max) {
                    startIndex = start;
                    endIndex = end;
                    max = sum;
                }

            }
        }

        System.out.println("StartIndex : " + startIndex + ", EndIndex : " + endIndex);
        System.out.println("Max : " + max);

    }

}
