package Level19;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BipartiteGraphCheck2 {

    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

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

        if (bfs(n, 1)) bw.write("Yes");
        else bw.write("No");

        br.close();
        bw.flush();
        bw.close();

    }

    private static boolean bfs(int n, int startVertex) {

        int[] isVisited = new int[n + 1];
        ArrayList<Integer> needVisit = new ArrayList<>();

        int color = 1;
        needVisit.add(startVertex);
        isVisited[startVertex] = color;


        while (!needVisit.isEmpty()) {

            int currentVertex = needVisit.remove(0);

            for (int w : graph.get(currentVertex)) {
                if (isVisited[w] == 0) {
                    isVisited[w] = isVisited[currentVertex] * -1;
                    needVisit.add(w);
                } else {
                    if (isVisited[w] == isVisited[currentVertex]) return false;
                }
            }

        }

        return true;

    }

}
