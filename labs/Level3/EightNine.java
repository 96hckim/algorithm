package Level3;

import java.io.*;
import java.util.StringTokenizer;

public class EightNine {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = m - 1; j >= 0; j--) {
                arr[i][j] = st.nextToken();
            }
        }

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
