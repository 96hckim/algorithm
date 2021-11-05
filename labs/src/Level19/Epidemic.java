package Level19;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Epidemic {

    private static int n;
    private static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bw.write(bfs(k) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int bfs(int k) {

        int count = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        visited[k] = true;

        while (!queue.isEmpty()) {

            int townNumber = queue.poll();
            count++;

            int mul = townNumber * 2;
            int div = townNumber / 3;

            if (mul <= n) {
                if (!visited[mul]) {
                    visited[mul] = true;
                    queue.add(mul);
                }
            }

            if (div > 0) {
                if (!visited[div]) {
                    visited[div] = true;
                    queue.add(div);
                }
            }

        }

        return n - count;

    }

}
