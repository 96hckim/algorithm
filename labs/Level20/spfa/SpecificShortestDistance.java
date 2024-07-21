package Level20.spfa;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SpecificShortestDistance {

    private static HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();

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
            int c = Integer.parseInt(st.nextToken());

            ArrayList<Edge> edgeA = graph.getOrDefault(a, new ArrayList<>());
            ArrayList<Edge> edgeB = graph.getOrDefault(b, new ArrayList<>());

            edgeA.add(new Edge(b, c));
            edgeB.add(new Edge(a, c));

            graph.put(a, edgeA);
            graph.put(b, edgeB);
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> distancesStart = dijkstra(1);
        HashMap<Integer, Integer> distancesA = dijkstra(A);
        HashMap<Integer, Integer> distancesB = dijkstra(B);

        int result1 = distancesStart.get(A) + distancesA.get(B) + distancesB.get(n);
        int result2 = distancesStart.get(B) + distancesB.get(A) + distancesA.get(n);

        bw.write(Math.min(result1, result2) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static HashMap<Integer, Integer> dijkstra(int start) {

        HashMap<Integer, Integer> distances = new HashMap<>();
        for (int key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(start, distances.get(start)));

        while (!priorityQueue.isEmpty()) {

            Edge edgeNode = priorityQueue.poll();
            int currentNode = edgeNode.getVertex();
            int currentDistance = edgeNode.getDistance();

            if (distances.get(currentNode) >= currentDistance) {

                ArrayList<Edge> nodeList = graph.get(currentNode);

                for (Edge adjacentNode : nodeList) {
                    int adjacent = adjacentNode.getVertex();
                    int weight = adjacentNode.getDistance();
                    int distance = currentDistance + weight;

                    if (distances.get(adjacent) > distance) {
                        distances.put(adjacent, distance);
                        priorityQueue.add(new Edge(adjacent, distance));
                    }
                }

            }

        }

        return distances;

    }

}
