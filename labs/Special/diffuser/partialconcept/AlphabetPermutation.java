package Special.diffuser.partialconcept;

import java.io.*;
import java.util.StringTokenizer;

public class AlphabetPermutation {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int R;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
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
        permutation(new char[R], 0);
        output();
    }

    private static void permutation(char[] selected, int x) throws IOException {
        if (x == R) {
            for (char c : selected) bw.write(c + "");
            bw.newLine();
        } else {
            for (char i = 'a'; i < 'a' + N; i++) {
                selected[x] = i;
                permutation(selected, x + 1);
            }
        }
    }

}
