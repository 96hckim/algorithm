package Special.poacher.move;

import java.io.*;
import java.util.StringTokenizer;

public class TwoDBigMove {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        if (d < 2) {
            t %= 2 * n - 2;
            y = getNext(y, t * dy[d], n);
        } else {
            t %= 2 * m - 2;
            x = getNext(x, t * dx[d], m);
        }

        bw.write(y + " " + x);

        br.close();
        bw.flush();
        bw.close();

    }

    private static int getNext(int position, int distance, int max) {

        while (position + distance < 1 || position + distance > max) {
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
