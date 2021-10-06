package Level3;

import java.io.*;
import java.util.StringTokenizer;

public class maxofarr {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int row = 0;
        int column = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    row = i + 1;
                    column = j + 1;
                }
            }
        }

        bw.write(max + "\n" + row + " " + column);

        br.close();
        bw.flush();
        bw.close();

    }

}
