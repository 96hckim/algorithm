package Special.aircleaner.push;

import java.io.*;
import java.util.StringTokenizer;

public class PushAlgorithm1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수열의 수
        int m = Integer.parseInt(st.nextToken()); // 수열의 길이
        int q = Integer.parseInt(st.nextToken()); // 질문의 수
        int[][] sequenceArray = new int[n][m]; // 수열

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                sequenceArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken()); // 수열 번호 (0부터)
            int x = Integer.parseInt(st.nextToken()); // 밀기 (1:오른쪽, 2:왼쪽)
            int y = Integer.parseInt(st.nextToken()); // 밀어낼 칸 수

            y %= m;

            push(sequenceArray, f, x, y);

            for (int j = 0; j < m; j++) {
                bw.write(sequenceArray[f][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void push(int[][] sequenceArray, int f, int x, int y) {
        for (int i = 0; i < y; i++) {

            if (x == 1) {

                int temp = sequenceArray[f][sequenceArray[0].length - 1];

                for (int j = sequenceArray[0].length - 1; j > 0; j--) {
                    sequenceArray[f][j] = sequenceArray[f][j - 1];
                }

                sequenceArray[f][0] = temp;

            } else {

                int temp = sequenceArray[f][0];

                for (int j = 0; j < sequenceArray[0].length - 1; j++) {
                    sequenceArray[f][j] = sequenceArray[f][j + 1];
                }

                sequenceArray[f][sequenceArray[0].length - 1] = temp;

            }

        }
    }

}
