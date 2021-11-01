package Level16;

import java.io.*;
import java.util.StringTokenizer;

public class ButtonPress {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] button = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            button[i][0] = red;
            button[i][1] = green;
            button[i][2] = blue;

            if (i > 0) {
                button[i][0] += Math.max(button[i - 1][1], button[i - 1][2]);
                button[i][1] += Math.max(button[i - 1][0], button[i - 1][2]);
                button[i][2] += Math.max(button[i - 1][0], button[i - 1][1]);
            }
        }

        int result = Math.max(button[n - 1][0], Math.max(button[n - 1][1], button[n - 1][2]));

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
