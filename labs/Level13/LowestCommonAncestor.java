package Level13;

import java.io.*;
import java.util.StringTokenizer;

public class LowestCommonAncestor {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] nodeArray = new int[n];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodeArray[b] = a;
        }

        boolean[] parent = new boolean[n];
        do {
            parent[x] = true;
            if (x == 0) break;
            x = nodeArray[x];
        } while (true);

        do {
            y = nodeArray[y];
        } while (!parent[y]);

        bw.write(y + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
