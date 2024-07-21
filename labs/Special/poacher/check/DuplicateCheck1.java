package Special.poacher.check;

import java.io.*;
import java.util.StringTokenizer;

public class DuplicateCheck1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[102][102];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[y][x]++;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) count++;
            }
        }

        bw.write(count + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
