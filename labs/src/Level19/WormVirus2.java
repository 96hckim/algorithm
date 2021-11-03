package Level19;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class WormVirus2 {

    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

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

        bw.write(bfs(1) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int bfs(int startVertex) {

        int count = 0;

        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> needVisit = new ArrayList<>();

        needVisit.add(startVertex);


        while (!needVisit.isEmpty()) {

            int currentVertex = needVisit.remove(0);

            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);
                if (graph.containsKey(currentVertex)) needVisit.addAll(graph.get(currentVertex));
                count++;
            }

        }

        return count - 1;

    }

}
