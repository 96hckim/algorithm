package Level20.scc;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Kosaraju {

    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static HashMap<Integer, ArrayList<Integer>> reverseGraph = new HashMap<>();

    private static int[] time;
    private static int clock = 1;
    private static boolean[] check;
    private static boolean[] reverseCheck;

    private static int[] order;
    private static int orderLength = 0;

    private static int[] group;
    private static int groupCount = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        time = new int[n + 1];
        check = new boolean[n + 1];
        order = new int[n + 1];
        reverseCheck = new boolean[n + 1];
        group = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayList<Integer> listA = graph.getOrDefault(a, new ArrayList<>());
            listA.add(b);
            graph.put(a, listA);

            ArrayList<Integer> listB = reverseGraph.getOrDefault(b, new ArrayList<>());
            listB.add(a);
            reverseGraph.put(b, listB);
        }

        // DFS 하면서 빠져나오는 순서대로 시간 기록
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                getTime(i);
            }
        }

        // 빠져나오는 순서대로 시간이 기록됨
        // 뒤집은 그래프에 대해서 빠져나오는 시간이 큰 노드부터 순회
        // 이 때 만나는 노드들이 모두 같은 그룹
        for (int i = order.length - 1; i >= 0; i--) {
            int node = order[i];

            if (!reverseCheck[node]) {
                getMyGroup(node);
                groupCount++;
            }
        }
        groupCount -= 2;

        bw.write(groupCount + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void getTime(int currentNode) {
        // node 부터 시작해서 DFS 하면서 빠져나오는 순서대로 시간을 기록
        check[currentNode] = true;

        ArrayList<Integer> nodeList = graph.getOrDefault(currentNode, new ArrayList<>());
        for (int adjacentNode : nodeList) {
            if (!check[adjacentNode]) {
                getTime(adjacentNode);
            }
        }

        time[currentNode] = clock;
        clock++;

        order[orderLength++] = currentNode;
    }

    private static void getMyGroup(int currentNode) {
        // node 에서부터 DFS, 하지만 거꾸로된 그래프에 대해서
        reverseCheck[currentNode] = true;
        group[currentNode] = groupCount;

        ArrayList<Integer> nodeList = reverseGraph.getOrDefault(currentNode, new ArrayList<>());
        for (int adjacentNode : nodeList) {
            if (!reverseCheck[adjacentNode]) {
                getMyGroup(adjacentNode);
            }
        }
    }

}
