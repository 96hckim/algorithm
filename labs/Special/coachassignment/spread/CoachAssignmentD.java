package Special.coachassignment.spread;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CoachAssignmentD {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static final HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static final ArrayList<Integer> questions = new ArrayList<>();

    private static int N;

    private static HashSet<Integer> coachA;
    private static HashSet<Integer> coachB;

    private static int MIN_QUESTIONS;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) graph.put(i, new ArrayList<>());
        MIN_QUESTIONS = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int nearby = Integer.parseInt(st.nextToken());
            questions.add(q);

            for (int j = 0; j < nearby; j++) {
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

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            coachA = new HashSet<>();
            for (int i = 0; i < N; i++) coachA.add(i);
            coachB = new HashSet<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            for (int i = 0; i < c; i++) {
                int value = st.nextToken().charAt(0) - 'A';
                coachA.remove(value);
                coachB.add(value);
            }

            if (!coachA.isEmpty() && !coachB.isEmpty()) {
                int A = 0;
                int B = 0;

                for (int index : coachA) A += questions.get(index);
                for (int index : coachB) B += questions.get(index);

                dfs(coachA.iterator().next(), coachA);
                dfs(coachB.iterator().next(), coachB);

                if (coachA.isEmpty() && coachB.isEmpty()) {

                    int sub = Math.abs(A - B);
                    if (MIN_QUESTIONS > sub) MIN_QUESTIONS = sub;
                }
            }
        }

        if (MIN_QUESTIONS == Integer.MAX_VALUE) bw.write("-1");
        else bw.write(MIN_QUESTIONS + "");

        output();
    }

    private static void dfs(int node, HashSet<Integer> coach) {
        coach.remove(node);

        ArrayList<Integer> connectList = graph.get(node);
        for (int connectNode : connectList) {
            if (coach.contains(connectNode)) {
                dfs(connectNode, coach);
            }
        }
    }

}
