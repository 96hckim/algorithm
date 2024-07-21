package Level14.example;

import java.io.IOException;

/**
 *  완전 탐색 n^3
 */
public class ConsecutivePartialMaximum1 {

    public static void main(String[] args) throws IOException {

        int[] arr = {1, 2, -4, 5, 3, -2, 9, 10};

        int max = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {

                int sum = 0;

                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }

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
