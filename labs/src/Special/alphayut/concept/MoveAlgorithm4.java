package Special.alphayut.concept;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MoveAlgorithm4 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static final HashMap<Integer, int[]> score = new HashMap<>();
    private static final HashMap<Integer, int[]> piece = new HashMap<>();

    private static boolean[] empty;
    private static int[] commands;
    private static int[] pieces;
    private static int MAX = Integer.MIN_VALUE;

    // 입력
    private static void input() throws IOException {
        commands = new int[10];
        pieces = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) commands[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) pieces[i] = Integer.parseInt(st.nextToken());

        empty = new boolean[1001];
        for (int i = 1; i <= 4; i++) piece.put(i, new int[2]);
    }

    // 출력
    private static void output() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

    private static void init() {
        score.put(0, new int[]{0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 55, 60, 65, 70, 75, 80, 85, 90, 95, 500, 1000});
        score.put(50, new int[]{50, 275, 250, 300, 150, 175, 75, 80, 85, 90, 95, 500, 1000});
        score.put(100, new int[]{100, 150, 125, 300, 350, 400, 500, 1000});
        score.put(300, new int[]{300, 350, 400, 500, 1000});
    }

    // 메인
    public static void main(String[] args) throws IOException {

        init();

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input();
            int r;
            if (move()) r = getResult();
            else r = -1;
            if (MAX < r) MAX = r;
        }

        bw.write(MAX + ""); // 결과 출력
        output();

    }

    private static boolean move() {
        for (int i = 0; i < 10; i++) {

            int command = commands[i];
            int p = pieces[i];

            int[] position = piece.get(p);
            int currentKey = position[0];
            int currentIndex = position[1];

            int[] s = score.get(currentKey);
            int currentScore = s[currentIndex];
            empty[currentScore] = false;

            int nextKey = currentKey;
            int nextIndex = command + currentIndex;
            if (nextIndex >= s.length - 1) nextIndex = s.length - 1;
            int nextScore = s[nextIndex];
            if (score.get(nextScore) != null) {
                nextKey = nextScore;
                nextIndex = 0;
            }

            if (!empty[nextScore] || nextScore == 1000) empty[nextScore] = true;
            else return false;

            piece.put(p, new int[]{nextKey, nextIndex});

        }

        return true;
    }

    private static int getResult() {
        int result = 0;

        for (int i = 1; i <= 4; i++) {
            int[] position = piece.get(i);
            int key = position[0];
            int index = position[1];
            result += score.get(key)[index];
        }

        return result;
    }

}
