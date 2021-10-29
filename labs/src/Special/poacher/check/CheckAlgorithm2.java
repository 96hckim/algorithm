package Special.poacher.check;

import java.io.*;
import java.util.StringTokenizer;

public class CheckAlgorithm2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[1002][1002];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            duplicateCheck(arr, y, x, age);
        }

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int age = Integer.parseInt(st.nextToken());

                duplicateCheck(arr, y, x, age);
            }

            bw.write(getAgeSum(arr) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void duplicateCheck(int[][] arr, int y, int x, int age) {
        if (arr[y][x] == 0) arr[y][x] = age;
        else {
            if (arr[y][x] < age) arr[y][x] = age;
        }
    }

    private static int getAgeSum(int[][] arr) {
        int sum = 0;

        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                sum += arr[i][j];
            }
        }

        return sum;
    }

}
