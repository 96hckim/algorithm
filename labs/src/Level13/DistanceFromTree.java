package Level13;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DistanceFromTree {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] treeArray = new int[n];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            treeArray[b] = a;
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);

        int count = 0;
        while (true) {
            distance[x] = count++;
            if (x == 0) break;
            x = treeArray[x];
        }

        count = 0;
        while (true) {
            if (distance[y] >= 0) {
                distance[y] += count;
                break;
            }
            distance[y] = count++;
            y = treeArray[y];
        }

        bw.write(distance[y] + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
