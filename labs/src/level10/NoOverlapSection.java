package level10;

import java.io.*;
import java.util.StringTokenizer;

public class NoOverlapSection {

    private static int n;
    private static int[] numberArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        numberArray = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numberArray[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = n;

        if (!isOverlap(start)) {
            System.out.println(start);
            return;
        }

        if (isOverlap(end)) {
            System.out.println(end);
            return;
        }

        while (start + 1 < end) {

            int mid = (start + end) / 2;

            if (isOverlap(mid)) {
                start = mid;
            } else {
                end = mid;
            }

        }

        bw.write(start + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static boolean isOverlap(int r) {

        int idx = 0;
        int countMoreThanTwo = 0;
        int[] countArray = new int[n + 1];
        for (int i = idx; i < idx + r; i++) {
            countArray[numberArray[i]]++;

            if (countArray[numberArray[i]] >= 2) {
                countMoreThanTwo++;
            }
        }

        if (countMoreThanTwo == 0) return true;

        while (idx + r < n) {

            countArray[numberArray[idx]]--;
            if (countArray[numberArray[idx]] >= 1) countMoreThanTwo--;

            idx++;

            countArray[numberArray[idx + r - 1]]++;
            if (countArray[numberArray[idx + r - 1]] >= 2) {
                countMoreThanTwo++;
            }

            if (countMoreThanTwo == 0) return true;

        }

        return false;

    }

}
