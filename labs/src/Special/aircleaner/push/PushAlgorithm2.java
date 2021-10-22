package Special.aircleaner.push;

import java.io.*;
import java.util.StringTokenizer;

public class PushAlgorithm2 {

    private static int n;
    private static int m;
    private static int u;
    private static int d;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 시계 방향

        int temp = arr[0][0];

        for (int i = 0; i < u; i++) arr[i][0] = arr[i + 1][0];

        for (int j = 0; j < m - 1; j++) arr[u][j] = arr[u][j + 1];

        for (int i = u; i > 0; i--) arr[i][m - 1] = arr[i - 1][m - 1];

        for (int j = m - 1; j > 1; j--) arr[0][j] = arr[0][j - 1];

        arr[0][1] = temp;

        // 반시계 방향

        temp = arr[d][0];

        for (int i = 0; i < m - 1; i++) arr[d][i] = arr[d][i + 1];

        for (int j = d; j < n - 1; j++) arr[j][m - 1] = arr[j + 1][m - 1];

        for (int i = m - 1; i > 0; i--) arr[n - 1][i] = arr[n - 1][i - 1];

        for (int j = n - 1; j > d + 1; j--) arr[j][0] = arr[j - 1][0];

        arr[d + 1][0] = temp;

        // 출력

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
