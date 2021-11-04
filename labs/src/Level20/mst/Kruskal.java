package Level20.mst;

import java.util.*;

class KruskalEdge implements Comparable<KruskalEdge> {

    private int weight;
    private String nodeV;
    private String nodeU;

    public KruskalEdge(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getNodeV() {
        return nodeV;
    }

    public void setNodeV(String nodeV) {
        this.nodeV = nodeV;
    }

    public String getNodeU() {
        return nodeU;
    }

    public void setNodeU(String nodeU) {
        this.nodeU = nodeU;
    }

    @Override
    public String toString() {
        return "KruskalEdge{" +
                "weight=" + weight +
                ", nodeV='" + nodeV + '\'' +
                ", nodeU='" + nodeU + '\'' +
                '}';
    }

    @Override
    public int compareTo(KruskalEdge edge) {
        return this.weight - edge.weight;
    }

}

public class Kruskal {

    private static HashMap<String, String> parent = new HashMap<>();
    private static HashMap<String, Integer> rank = new HashMap<>();

    public static void main(String[] args) {

        ArrayList<String> vertices = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<KruskalEdge> edges = new ArrayList<>();
        edges.add(new KruskalEdge(7, "A", "B"));
        edges.add(new KruskalEdge(5, "A", "D"));
        edges.add(new KruskalEdge(7, "B", "A"));
        edges.add(new KruskalEdge(8, "B", "C"));
        edges.add(new KruskalEdge(9, "B", "D"));
        edges.add(new KruskalEdge(7, "B", "E"));
        edges.add(new KruskalEdge(8, "C", "B"));
        edges.add(new KruskalEdge(5, "C", "E"));
        edges.add(new KruskalEdge(5, "D", "A"));
        edges.add(new KruskalEdge(9, "D", "B"));
        edges.add(new KruskalEdge(7, "D", "E"));
        edges.add(new KruskalEdge(6, "D", "F"));
        edges.add(new KruskalEdge(7, "E", "B"));
        edges.add(new KruskalEdge(5, "E", "C"));
        edges.add(new KruskalEdge(7, "E", "D"));
        edges.add(new KruskalEdge(8, "E", "F"));
        edges.add(new KruskalEdge(9, "E", "G"));
        edges.add(new KruskalEdge(6, "F", "D"));
        edges.add(new KruskalEdge(8, "F", "E"));
        edges.add(new KruskalEdge(11, "F", "G"));
        edges.add(new KruskalEdge(9, "G", "E"));
        edges.add(new KruskalEdge(11, "G", "F"));

        System.out.println(kruskal(vertices, edges));

    }

    private static String find(String node) {
        // path compression 기법
        if (!Objects.equals(parent.get(node), node)) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    private static void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank 기법
        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if (Objects.equals(rank.get(root1), rank.get(root2))) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }

    private static void makeSet(String node) {
        parent.put(node, node);
        rank.put(node, 0);
    }

    private static ArrayList<KruskalEdge> kruskal(ArrayList<String> vertices, ArrayList<KruskalEdge> edges) {
        ArrayList<KruskalEdge> mst = new ArrayList<>();

        // 초기화
        for (String vertex : vertices) {
            makeSet(vertex);
        }

        // 간선 weight 기반 정렬
        Collections.sort(edges);

        for (KruskalEdge currentEdge : edges) {
            if (!Objects.equals(find(currentEdge.getNodeV()), find(currentEdge.getNodeU()))) {
                union(currentEdge.getNodeV(), currentEdge.getNodeU());
                mst.add(currentEdge);
            }
        }

        return mst;
    }

}
