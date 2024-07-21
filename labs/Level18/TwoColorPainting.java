package Level18;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TwoColorPainting {

    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static int[] visited;
    private static boolean canTwoColors = true;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayList<Integer> vertexA = graph.getOrDefault(a, new ArrayList<>());
            ArrayList<Integer> vertexB = graph.getOrDefault(b, new ArrayList<>());

            vertexA.add(b);
            vertexB.add(a);

            graph.put(a, vertexA);
            graph.put(b, vertexB);
        }

        dfs(0, 1);

        if (canTwoColors) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void dfs(int vertex, int color) {

        visited[vertex] = color;

        for (int w : graph.get(vertex)) {
            if (visited[w] == 0) {
                dfs(w, color * -1);
            } else {
                if (color == visited[w]) canTwoColors = false;
            }
        }

    }

}
