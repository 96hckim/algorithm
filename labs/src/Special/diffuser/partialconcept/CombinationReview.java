package Special.diffuser.partialconcept;

import java.io.*;

public class CombinationReview {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
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
        permutation(new int[N], 0);
        output();
    }

    private static void permutation(int[] selected, int x) throws IOException {
        if (x == N) {
            for (int num : selected) bw.write(num + " ");
            bw.newLine();
        } else {
            for (int i = 0; i < 2; i++) {
                selected[x] = i;
                permutation(selected, x + 1);
            }
        }
    }

}
