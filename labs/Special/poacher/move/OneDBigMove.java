package Special.poacher.move;

import java.io.*;
import java.util.StringTokenizer;

public class OneDBigMove {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] dx = {-1, 1};

        t %= 2 * n - 2;

        while (x + t * dx[d] < 1 || x + t * dx[d] > n) {
            if (x + t * dx[d] < 1) {
                t -= x - 1;
                x = 1;
                d = 1;
            } else if (x + t * dx[d] > n) {
                t -= n - x;
                x = n;
                d = 0;
            }
        }

        x += t * dx[d];

        bw.write(x + " " + d);

        br.close();
        bw.flush();
        bw.close();

    }

}
