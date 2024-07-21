package Special.poacher.move;

import java.io.*;
import java.util.StringTokenizer;

public class MoveAlgorithm2 {

    private static int[] d;
    private static int[] nd;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        nd = new int[]{1, 0, 3, 2};

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] y = new int[k];
        int[] x = new int[k];
        d = new int[k];
        int[] f = new int[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            y[i] = Integer.parseInt(st.nextToken());
            x[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
            f[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < k; j++) {
                if (d[j] < 2) {
                    f[j] %= 2 * n - 2;
                    y[j] = getNext(y[j], f[j] * dy[d[j]], n, j);
                } else {
                    f[j] %= 2 * m - 2;
                    x[j] = getNext(x[j], f[j] * dx[d[j]], m, j);
                }
            }
        }

        for (int i = 0; i < k; i++) {
            bw.write(y[i] + " " + x[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static int getNext(int position, int distance, int max, int index) {

        while (position + distance < 1 || position + distance > max) {

            d[index] = nd[d[index]];

            if (position + distance < 1) {
                distance += position - 1;
                position = 1;
            } else if (position + distance > max) {
                distance -= max - position;
                position = max;
            }

            distance = -distance;

        }

        return position + distance;

    }

}
