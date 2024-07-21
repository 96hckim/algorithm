package Special.coachassignment.spread;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CoachAssignmentB {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int M;
    private static int E;

    private static HashSet<Integer> needVisit;
    private static boolean[] visited;
    private static final HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        needVisit = new HashSet<>();
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            needVisit.add(st.nextToken().charAt(0) - 'A');
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A';
            int b = st.nextToken().charAt(0) - 'A';

            HashSet<Integer> listA = graph.getOrDefault(a, new HashSet<>());
            HashSet<Integer> listB = graph.getOrDefault(b, new HashSet<>());

            listA.add(b);
            listB.add(a);

            graph.put(a, listA);
            graph.put(b, listB);
        }
    }

    // 출력
    private static void output() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

    // 메인
    public static void main(String[] args) throws IOException {
        input();
        dfs(needVisit.iterator().next());
        boolean isConnected = true;
        for (int node : needVisit) {
            if (!visited[node]) {
                isConnected = false;
                break;
            }
        }
        if (isConnected) bw.write("1");
        else bw.write("0");
        output();
    }

    private static void dfs(int node) {
        visited[node] = true;
        needVisit.remove(node);

        HashSet<Integer> visitList = graph.getOrDefault(node, new HashSet<>());
        for (int visitNode : visitList) {
            if (needVisit.contains(visitNode) && !visited[visitNode]) dfs(visitNode);
        }
    }

}
