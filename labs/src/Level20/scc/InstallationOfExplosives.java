package Level20.scc;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class InstallationOfExplosives {

    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    private static boolean[] check;

    private static int[] time;
    private static int clock = 1;

    private static int[] order;
    private static int orderIndex = 0;

    private static int[] group;
    private static int groupCount = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        check = new boolean[n + 1];
        time = new int[n + 1];
        order = new int[n + 1];
        group = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayList<Integer> adjacentListA = graph.getOrDefault(a, new ArrayList<>());
            adjacentListA.add(b);
            graph.put(a, adjacentListA);
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                getTime(i);
            }
        }

        check = new boolean[n + 1];

        for (int i = orderIndex - 1; i >= 0; i--) {
            int node = order[i];

            if (!check[node]) {
                getMyGroup(node);
                groupCount++;
            }
        }
        groupCount--;

        bw.write(groupCount + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void getTime(int currentNode) {
        check[currentNode] = true;

        ArrayList<Integer> nodeList = graph.getOrDefault(currentNode, new ArrayList<>());
        for (int adjacentNode : nodeList) {
            if (!check[adjacentNode]) {
                getTime(adjacentNode);
            }
        }

        time[currentNode] = clock++;
        order[orderIndex++] = currentNode;
    }

    private static void getMyGroup(int currentNode) {
        check[currentNode] = true;
        group[currentNode] = groupCount;

        ArrayList<Integer> nodeList = graph.getOrDefault(currentNode, new ArrayList<>());
        for (int adjacentNode : nodeList) {
            if (!check[adjacentNode]) {
                getMyGroup(adjacentNode);
            }
        }
    }

}
