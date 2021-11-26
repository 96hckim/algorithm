package Special.coachassignment;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CoachAssignment {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static HashMap<Integer, ArrayList<Integer>> graph; // 수강생 연결 그래프
    private static ArrayList<Integer> questions; // 수강생별 질문 수

    private static int N; // 수강생 수

    private static int MIN_QUESTIONS; // 최소 질문 수

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        graph = new HashMap<>(N);
        questions = new ArrayList<>(N);
        MIN_QUESTIONS = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) graph.put(i, new ArrayList<>());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            questions.add(q);

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

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input();

            for (int i = 1; i < N; i++) recursive(new int[i], 0, 0); // 완전 탐색

            bw.write("#" + t + " ");
            if (MIN_QUESTIONS == Integer.MAX_VALUE) bw.write("-1\n"); // 인원 배정 불가하면 -1 출력
            else bw.write(MIN_QUESTIONS + "\n"); // 인원 배정 가능하면 최소 질문 수 출력
        }

        output();

    }

    // 재귀로 모든 경우의 수 확인
    private static void recursive(int[] selected, int x, int from) {
        if (x == selected.length) {
            connectedCheck(selected);
        } else {
            for (int i = from; i < N; i++) {
                selected[x] = i;
                recursive(selected, x + 1, i + 1);
            }
        }
    }

    // 코치별 수강생들끼리 연결되었는지 체크 및 최소값 구하기
    private static void connectedCheck(int[] selected) {
        HashSet<Integer> coachA = new HashSet<>();
        HashSet<Integer> coachB = new HashSet<>();

        for (int i = 0; i < N; i++) coachA.add(i);

        for (int num : selected) {
            coachA.remove(num);
            coachB.add(num);
        }

        int sumA = questionsSum(coachA);
        int sumB = questionsSum(coachB);

        dfs(coachA.iterator().next(), coachA);
        dfs(coachB.iterator().next(), coachB);

        if (coachA.isEmpty() && coachB.isEmpty()) { // 코치별 수강생들끼리 연결 O
            minQuestionsCheck(sumA, sumB);
        }
    }

    // 해당 코치의 수강생들 질문 수의 합
    private static int questionsSum(HashSet<Integer> coach) {
        int sum = 0;

        for (int index : coach) sum += questions.get(index);

        return sum;
    }

    // 해당 코치의 수강생들끼리 연결되었는지 확인
    private static void dfs(int node, HashSet<Integer> coach) {
        coach.remove(node);

        ArrayList<Integer> connectList = graph.get(node);
        for (int connectNode : connectList) {
            if (coach.contains(connectNode)) dfs(connectNode, coach);
        }
    }

    // 최소 질문 수 체크
    private static void minQuestionsCheck(int A, int B) {
        int sum = Math.abs(A - B);
        if (MIN_QUESTIONS > sum) MIN_QUESTIONS = sum;
    }

}
