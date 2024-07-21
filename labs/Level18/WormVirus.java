package Level18;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WormVirus {

    private static final HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static boolean[] visited;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayList<Integer> adjacentListA = graph.getOrDefault(a, new ArrayList<>());
            ArrayList<Integer> adjacentListB = graph.getOrDefault(b, new ArrayList<>());

            adjacentListA.add(b);
            adjacentListB.add(a);

            graph.put(a, adjacentListA);
            graph.put(b, adjacentListB);
        }

        dfs(1);

        bw.write(count + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void dfs(int i) {
        visited[i] = true;

        ArrayList<Integer> nodeList = graph.getOrDefault(i, new ArrayList<>());
        for (int node : nodeList) {
            if (!visited[node]) {
                count++;
                dfs(node);
            }
        }
    }

}
