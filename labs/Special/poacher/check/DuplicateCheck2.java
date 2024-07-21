package Special.poacher.check;

import java.io.*;
import java.util.StringTokenizer;

public class DuplicateCheck2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] duplicateArray = new int[102][102];

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (duplicateArray[x][y] == 0) duplicateArray[y][x] = i;
        }

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                sum += duplicateArray[i][j];
            }
        }

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
