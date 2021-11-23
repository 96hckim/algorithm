package Special.alphayut.partialconcept;

import java.io.*;
import java.util.StringTokenizer;

public class MoveN {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int[] board;
    private static int[] command;

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
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
        board = new int[22];
        for (int i = 0; i < board.length; i++) board[i] = 5 * i;
        board[5] = 50;
        board[10] = 100;
        board[15] = 75;
        board[20] = 500;
        board[board.length - 1] = 1000;
    }

    // 메인
    public static void main(String[] args) throws IOException {
        init();
        input();
        int index = 0;
        for (int move : command) {
            index += move;
            if (index >= board.length - 1) {
                bw.write(1000 + "");
                break;
            }
            bw.write(board[index] + " ");
        }
        output();
    }

}
