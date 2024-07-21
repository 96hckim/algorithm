package Level20.spfa;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

    private int vertex;
    private int distance;

    public Edge(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        return "DijkstraEdge{" +
                "distance=" + distance +
                ", vertex=" + vertex +
                '}';
    }

    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }

}

public class Dijkstra {

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

            ArrayList<Edge> edgeA = graph.getOrDefault(a, new ArrayList<>());
            ArrayList<Edge> edgeB = graph.getOrDefault(b, new ArrayList<>());

            edgeA.add(new Edge(b, 1));
            edgeB.add(new Edge(a, 1));

            graph.put(a, edgeA);
            graph.put(b, edgeB);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> distances = dijkstra(start);

        bw.write(distances.get(end) + "");

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
            int currentDistance = edgeNode.getDistance();
            int currentNode = edgeNode.getVertex();

            if (distances.get(currentNode) >= currentDistance) {
                ArrayList<Edge> nodeList = graph.get(currentNode);

                for (Edge adjacentNode : nodeList) {
                    int adjacent = adjacentNode.getVertex();
                    int weight = adjacentNode.getDistance();
                    int distance = currentDistance + weight;

                    if (distance < distances.get(adjacent)) {
                        distances.put(adjacent, distance);
                        priorityQueue.add(new Edge(adjacent, distance));
                    }
                }
            }

        }

        return distances;

    }

}
