package Special.coachassignment.spread;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CoachAssignmentC {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static final HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    private static int N;
    private static int M;
    private static int E;

    private static HashSet<Integer> coachA;
    private static HashSet<Integer> coachB;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        coachA = new HashSet<>();
        for (int i = 0; i < N; i++) coachA.add(i);
        coachB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int value = st.nextToken().charAt(0) - 'A';
            coachA.remove(value);
            coachB.add(value);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A';
            int b = st.nextToken().charAt(0) - 'A';

            ArrayList<Integer> listA = graph.getOrDefault(a, new ArrayList<>());
            ArrayList<Integer> listB = graph.getOrDefault(b, new ArrayList<>());

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
        if (!coachA.isEmpty() && !coachB.isEmpty()) {
            dfs(coachA.iterator().next(), coachA);
            dfs(coachB.iterator().next(), coachB);
            if (coachA.isEmpty() && coachB.isEmpty()) bw.write("1");
            else bw.write("0");
        } else bw.write("0");
        output();
    }

    private static void dfs(int node, HashSet<Integer> coach) {
        coach.remove(node);

        ArrayList<Integer> connectList = graph.getOrDefault(node, new ArrayList<>());
        for (int connectNode : connectList) {
            if (coach.contains(connectNode)) {
                dfs(connectNode, coach);
            }
        }
    }

}
