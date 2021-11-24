package Special.alphayut.concept;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MoveAlgorithm4 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static final HashMap<Integer, int[]> score = new HashMap<>(4);
    private static final HashMap<Integer, int[]> board = new HashMap<>(4);
    private static final HashMap<Integer, int[]> piece = new HashMap<>(4);

    private static int[] commands;
    private static int[] currentPieces;
    private static int MAX_VALUE = Integer.MIN_VALUE;

    // 입력
    private static void input() throws IOException {
        commands = new int[10];
        currentPieces = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) commands[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) currentPieces[i] = Integer.parseInt(st.nextToken());

        board.put(0, new int[score.get(0).length]);
        board.put(50, new int[score.get(50).length]);
        board.put(100, new int[score.get(100).length]);
        board.put(300, new int[score.get(300).length]);

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
            int result;
            if (move()) result = getResult();
            else result = -1;
            if (MAX_VALUE < result) MAX_VALUE = result;
        }

        bw.write(MAX_VALUE + "");

        output();

    }

    private static boolean move() {
        for (int i = 0; i < 10; i++) {

            int yut = commands[i];
            int currentPiece = currentPieces[i];

            int[] position = piece.get(currentPiece);
            int key = position[0];
            int currentIndex = position[1];
            int nextIndex = yut + currentIndex;

            int[] s = score.get(key);
            int[] b = board.get(key);
            b[currentIndex] = 0;
            if (nextIndex >= b.length - 1) nextIndex = b.length - 1;
            if (score.get(s[nextIndex]) != null) {
                key = s[nextIndex];
                nextIndex = 0;
                b = board.get(key);
            }

            if (b[nextIndex] == 0 || nextIndex == b.length - 1) b[nextIndex] = currentPiece;
            else return false;

            piece.put(currentPiece, new int[]{key, nextIndex});
        }

        return true;
    }

    private static int getResult() {
        int result = 0;

        for (int i = 1; i <= 4; i++) {
            int[] position = piece.get(i);
            int key = position[0];
            int index = position[1];
            int lastScore = score.get(key)[index];
            result += lastScore;
        }

        return result;
    }

}