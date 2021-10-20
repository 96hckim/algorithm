package level10;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountingNumbers {

    private static int n;
    private static int[] numberArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        numberArray = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numberArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numberArray);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int searchItem = Integer.parseInt(st.nextToken());

            int start = findStart(searchItem);
            if (start == -1) {
                bw.write("0\n");
                continue;
            }
            int end = findEnd(searchItem);
            bw.write(end - start + 1 + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static int findStart(int searchItem) {

        int start, end;

        if (numberArray[0] < searchItem) start = 0;
        else {
            if (numberArray[0] > searchItem) return -1;
            else return 0;
        }

        if (numberArray[n - 1] >= searchItem) end = n - 1;
        else return -1;

        while (start + 1 < end) {

            int median = (start + end) / 2;

            if (numberArray[median] < searchItem) start = median;
            else end = median;

        }

        if (numberArray[end] == searchItem) return end;
        else return -1;

    }

    private static int findEnd(int searchItem) {

        int start, end;

        if (numberArray[0] <= searchItem) start = 0;
        else return -1;

        if (numberArray[n - 1] > searchItem) end = n - 1;
        else {
            if (numberArray[n - 1] < searchItem) return -1;
            else return n - 1;
        }

        while (start + 1 < end) {

            int median = (start + end) / 2;

            if (numberArray[median] <= searchItem) start = median;
            else end = median;

        }

        if (numberArray[start] == searchItem) return start;
        else return -1;

    }

}
