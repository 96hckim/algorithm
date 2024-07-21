package Level10;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSolutions {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] solutions = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int result1 = 0;
        int result2 = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < solutions.length - 1; i++) {

            int start = i + 1;
            int end = solutions.length - 1;
            int searchItem = solutions[i] * -1;

            int idx = binarySearch(solutions, start, end, searchItem);
            int sum = Math.abs(solutions[i] + solutions[idx]);

            if (sum < min) {
                result1 = solutions[i];
                result2 = solutions[idx];

                if (sum == 0) break;
                else min = sum;
            }

        }

        bw.write(result1 + " " + result2);

        br.close();
        bw.flush();
        bw.close();

    }

    private static int binarySearch(int[] solutions, int start, int end, int searchItem) {

        int smallerIdx = start;
        int biggerIdx = end;

        do {

            int medianIdx = (smallerIdx + biggerIdx) / 2;

            if (solutions[medianIdx] == searchItem) {
                return medianIdx;
            } else {
                if (solutions[medianIdx] < searchItem) {
                    smallerIdx = medianIdx + 1;
                } else {
                    biggerIdx = medianIdx - 1;
                }
            }

        } while (smallerIdx <= biggerIdx);

        if (smallerIdx > end) {
            return biggerIdx;
        } else if (biggerIdx < start) {
            return smallerIdx;
        }

        if (Math.abs(searchItem - solutions[smallerIdx]) < Math.abs(searchItem - solutions[biggerIdx])) {
            return smallerIdx;
        } else {
            return biggerIdx;
        }

    }

}
