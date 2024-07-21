package Test.line2019intern;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCardGame {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int[] cards;
    private static boolean[] used;
    private static int K;
    private static int COUNT;

    // 입력
    private static void input() throws IOException {
        cards = new int[3];
        used = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        cards[0] = Integer.parseInt(st.nextToken());
        cards[1] = Integer.parseInt(st.nextToken());
        cards[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        K = Integer.parseInt(br.readLine());
        COUNT = 0;
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
        recursive(new int[3], 0);
        output();
    }

    private static void recursive(int[] selected, int x) throws IOException {
        if (x == 3) {
            if (K == ++COUNT) for (int num : selected) bw.write(num + " ");
        } else {
            for (int num : cards) {
                if (!used[num]) {
                    selected[x] = num;
                    used[num] = true;
                    recursive(selected, x + 1);
                    used[num] = false;
                }
            }
        }
    }

}
