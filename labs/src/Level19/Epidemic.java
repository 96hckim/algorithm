package Level19;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Epidemic {

    private static boolean[] town;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        town = new boolean[n + 1];

        bw.write(bfs(n, k) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int bfs(int n, int k) {

        int infectionCount = 0;
        ArrayList<Integer> needVisit = new ArrayList<>();
        needVisit.add(k);
        town[k] = true;

        while (!needVisit.isEmpty()) {

            int w = needVisit.remove(0);
            infectionCount++;

            int mul = w * 2;
            int div = w / 3;

            if (mul <= n) {
                if (!town[mul]) {
                    needVisit.add(mul);
                    town[mul] = true;
                }
            }

            if (div > 0) {
                if (!town[div]) {
                    needVisit.add(div);
                    town[div] = true;
                }
            }

        }

        return n - infectionCount;

    }

}
