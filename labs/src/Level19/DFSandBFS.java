package Level19;

import java.io.*;
import java.util.*;

public class DFSandBFS {

    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static ArrayList<Integer> dfsResult = new ArrayList<>();
    private static ArrayList<Integer> bfsResult = new ArrayList<>();
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n];

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

        for (int key : graph.keySet()) {
            ArrayList<Integer> adjacentVertexes = graph.get(key);
            Collections.sort(adjacentVertexes);
            graph.put(key, adjacentVertexes);
        }

        dfs(0);
        bfs(0);

        for (int dfs : dfsResult) bw.write(dfs + " ");
        bw.newLine();
        for (int bfs : bfsResult) bw.write(bfs + " ");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void dfs(int currentVertex) {

        isVisited[currentVertex] = true;
        dfsResult.add(currentVertex);

        for (int vertex : graph.get(currentVertex)) {
            if (!isVisited[vertex]) {
                dfs(vertex);
            }
        }

    }

    private static void bfs(int startVertex) {

        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> needVisit = new ArrayList<>();

        needVisit.add(startVertex);

        while (!needVisit.isEmpty()) {

            int currentVertex = needVisit.remove(0);

            if (!visited.contains(currentVertex)) {
                bfsResult.add(currentVertex);
                visited.add(currentVertex);
                needVisit.addAll(graph.get(currentVertex));
            }

        }

    }

}
