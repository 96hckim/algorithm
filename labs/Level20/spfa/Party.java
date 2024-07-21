package Level20.spfa;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Party {

    private static int N;
    private static int M;
    private static int K;

    private static HashMap<Integer, ArrayList<Edge>> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ArrayList<Edge> nodeList = graph.getOrDefault(a, new ArrayList<>());
            nodeList.add(new Edge(b, c));

            graph.put(a, nodeList);
        }

        HashMap<Integer, Integer> distancesStart = dijkstra(K);

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (N != K) sum += dijkstra(i).get(K) + distancesStart.get(i);
        }

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static HashMap<Integer, Integer> dijkstra(int startNode) {

        HashMap<Integer, Integer> distances = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(startNode, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(startNode, distances.get(startNode)));

        while (!priorityQueue.isEmpty()) {

            Edge edgeNode = priorityQueue.poll();
            int currentVertex = edgeNode.getVertex();
            int currentDistance = edgeNode.getDistance();

            if (distances.get(currentVertex) >= currentDistance) {

                ArrayList<Edge> nodeList = graph.getOrDefault(currentVertex, new ArrayList<>());

                for (Edge adjacentNode : nodeList) {
                    int vertex = adjacentNode.getVertex();
                    int weight = adjacentNode.getDistance();
                    int distance = currentDistance + weight;

                    if (distances.get(vertex) > distance) {
                        distances.put(vertex, distance);
                        priorityQueue.add(new Edge(vertex, distance));
                    }
                }

            }

        }

        return distances;

    }

}
