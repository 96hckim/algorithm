package Level16;

import java.io.*;
import java.util.StringTokenizer;

public class SumOfRectangles {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] rectangle = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += Integer.parseInt(st.nextToken());
                if (i > 0) rectangle[i][j] = sum + rectangle[i - 1][j];
                else rectangle[i][j] = sum;
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int sum = 0;
            if (a == 0 && b == 0) sum = rectangle[c][d];
            else if (a == 0) sum = rectangle[c][d] - rectangle[c][b - 1];
            else if (b == 0) sum = rectangle[c][d] - rectangle[a - 1][d];
            else if (a > 0 && b > 0) sum = rectangle[c][d] - rectangle[a - 1][d] - rectangle[c][b - 1] + rectangle[a - 1][b - 1];

            bw.write(sum + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
