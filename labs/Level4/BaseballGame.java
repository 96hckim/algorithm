package Level4;

import java.io.*;
import java.util.StringTokenizer;

public class BaseballGame {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] informationArray = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            informationArray[i][0] = Integer.parseInt(st.nextToken());
            informationArray[i][1] = Integer.parseInt(st.nextToken());
            informationArray[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {

                    if (i != j && j != k && i != k) {
                        if (!isDiff(informationArray, i, j, k)) result++;
                    }

                }
            }
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();

    }

    static boolean isDiff(int[][] arr, int i, int j, int k) {
        boolean isDiff = false;

        for (int[] information : arr) {

            int first = information[0] / 100;
            int second = (information[0] / 10) % 10;
            int third = information[0] % 10;

            int strike = 0;
            int ball = 0;

            if (i == first) strike++;
            else if (i == second || i == third) ball++;

            if (j == second) strike++;
            else if (j == first || j == third) ball++;

            if (k == third) strike++;
            else if (k == first || k == second) ball++;

            if (information[1] != strike || information[2] != ball) {
                isDiff = true;
                break;
            }

        }

        return isDiff;
    }

}
