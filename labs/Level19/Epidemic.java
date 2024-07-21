package Level19;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Epidemic {

    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(bfs() + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int bfs() {

        int count = N;
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> needVisit = new LinkedList<>();
        needVisit.add(K);
        visited[K] = true;

        while (!needVisit.isEmpty()) {

            int town = needVisit.poll();
            count--;

            int mul = town * 2;
            int div = town / 3;

            if (mul <= N) {
                if (!visited[mul]) {
                    visited[mul] = true;
                    needVisit.add(mul);
                }
            }

            if (div > 0) {
                if (!visited[div]) {
                    visited[div] = true;
                    needVisit.add(div);
                }
            }

        }

        return count;

    }

}
