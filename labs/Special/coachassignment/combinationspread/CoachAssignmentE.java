package Special.coachassignment.combinationspread;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CoachAssignmentE {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static final HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    private static int N;

    private static int CASE;

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        CASE = 0;
        for (int i = 0; i < N; i++) graph.put(i, new ArrayList<>());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());

            for (int j = 0; j < c; j++) {
                int b = st.nextToken().charAt(0) - 'A';
                ArrayList<Integer> listA = graph.get(i);
                ArrayList<Integer> listB = graph.get(b);

                listA.add(b);
                listB.add(i);

                graph.put(i, listA);
                graph.put(b, listB);
            }
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
        for (int i = 1; i < N; i++) recursive(new int[i], 0, 0);
        bw.write(CASE + "");
        output();
    }

    private static void recursive(int[] selected, int x, int from) {
        if (x == selected.length) {
            HashSet<Integer> coachA = new HashSet<>();
            HashSet<Integer> coachB = new HashSet<>();
            for (int i = 0; i < N; i++) coachA.add(i);

            for (int num : selected) {
                coachA.remove(num);
                coachB.add(num);
            }

            dfs(coachA.iterator().next(), coachA);
            dfs(coachB.iterator().next(), coachB);

            if (coachA.isEmpty() && coachB.isEmpty()) CASE++;
        } else {
            for (int i = from; i < N; i++) {
                selected[x] = i;
                recursive(selected, x + 1, i + 1);
            }
        }
    }

    private static void dfs(int node, HashSet<Integer> coach) {
        coach.remove(node);

        ArrayList<Integer> connectList = graph.get(node);
        for (int connectNode : connectList) {
            if (coach.contains(connectNode)) dfs(connectNode, coach);
        }
    }

}
