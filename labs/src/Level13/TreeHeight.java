package Level13;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TreeHeight {

    private static int[] nodesHeight;
    private static HashMap<Integer, ArrayList<Integer>> treeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        nodesHeight = new int[n];
        Arrays.fill(nodesHeight, -1);

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayList<Integer> parentConnectedNodes = treeMap.getOrDefault(a, new ArrayList<>());
            parentConnectedNodes.add(b);
            ArrayList<Integer> childConnectedNodes = treeMap.getOrDefault(b, new ArrayList<>());
            childConnectedNodes.add(a);

            treeMap.put(a, parentConnectedNodes);
            treeMap.put(b, childConnectedNodes);
        }

        dfs(0, r);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < nodesHeight[i]) max = nodesHeight[i];
        }

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void dfs(int height, int key) {
        nodesHeight[key] = height;
        ArrayList<Integer> nodes = treeMap.getOrDefault(key, new ArrayList<>());
        for (int node : nodes) {
            if (nodesHeight[node] == -1) {
                dfs(height + 1, node);
            }
        }
    }

}
