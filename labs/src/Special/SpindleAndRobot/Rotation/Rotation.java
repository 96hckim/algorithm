package Special.SpindleAndRobot.Rotation;

import java.io.*;
import java.util.StringTokenizer;

public class Rotation {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            y %= n;

            if (d == 1) {
                if (x + y >= n) {
                    x = x + (y - n);
                } else {
                    x = x + y;
                }
            } else {
                if (x - y < 0) {
                    x = n - (y - x);
                } else {
                    x = x - y;
                }
            }

            bw.write(arr[x] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
