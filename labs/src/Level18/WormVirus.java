package Level18;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class WormVirus {

    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayList<Integer> vertexA = graph.getOrDefault(a, new ArrayList<>());
            ArrayList<Integer> vertexB = graph.getOrDefault(b, new ArrayList<>());

            vertexA.add(b);
            vertexB.add(a);

            graph.put(a, vertexA);
            graph.put(b, vertexB);
        }

        bw.write(dfs(1) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int dfs(int vertex) {

        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> needVisit = new ArrayList<>();

        needVisit.add(vertex);

        int count = 0;

        while (needVisit.size() > 0) {

            int w = needVisit.remove(needVisit.size() - 1);

            if (!visited.contains(w)) {
                count++;
                visited.add(w);
                if (graph.containsKey(w)) needVisit.addAll(graph.get(w));
            }

        }

        return count - 1;

    }

}
