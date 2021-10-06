package Level3;

import java.io.*;
import java.util.StringTokenizer;

public class Offset {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int row = 5;
        int column = 5;

        int[][] arr = new int[row + 2][column + 2];

        for (int i = 1; i < arr.length - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arr[0].length - 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[0][i] = 10;
            arr[6][i] = 10;
            arr[i][0] = 10;
            arr[i][6] = 10;
        }

        for (int i = 1; i <= arr.length - 2; i++) {
            for (int j = 1; j <= arr[0].length - 2; j++) {
                int value = arr[i][j];

                int top = arr[i - 1][j];
                int bottom = arr[i + 1][j];
                int left = arr[i][j - 1];
                int right = arr[i][j + 1];

                if (top > value && bottom > value && left > value && right > value) {
                    bw.write("* ");
                } else {
                    bw.write(value + " ");
                }
            }

            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
