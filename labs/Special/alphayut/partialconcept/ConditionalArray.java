package Special.alphayut.partialconcept;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ConditionalArray {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static final HashMap<Integer, int[]> map = new HashMap<>(4);
    private static int KEY;
    private static int[] command;

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        KEY = 0;
        command = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) command[i] = Integer.parseInt(st.nextToken());
    }

    // 출력
    private static void output() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

    private static void init() {
        map.put(0, new int[]{0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 55, 60, 65, 70, 75, 80, 85, 90, 95, 500, 1000});
        map.put(50, new int[]{50, 275, 250, 300, 150, 175, 75, 80, 85, 90, 95, 500, 1000});
        map.put(100, new int[]{100, 150, 125, 300, 350, 400, 500, 1000});
        map.put(300, new int[]{300, 350, 400, 500, 1000});
    }

    // 메인
    public static void main(String[] args) throws IOException {
        init();
        input();
        int index = 0;
        for (int move : command) {
            int[] board = map.get(KEY);
            index += move;
            if (index >= board.length - 1) {
                bw.write(1000 + " ");
                break;
            }
            bw.write(board[index] + " ");
            int[] next = map.get(board[index]);
            if (next != null) {
                KEY = board[index];
                index = 0;
            }
        }
        output();
    }

}
