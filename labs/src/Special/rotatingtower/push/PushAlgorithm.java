package Special.rotatingtower.push;

import java.io.*;
import java.util.StringTokenizer;

public class PushAlgorithm {

    private static int n, m, q;
    private static int[][] sequenceArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 수열의 갯수
        m = Integer.parseInt(st.nextToken()); // 길이
        q = Integer.parseInt(st.nextToken()); // 질문의 수
        sequenceArray = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                sequenceArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken()); // f번 수열
            int x = Integer.parseInt(st.nextToken()); // 1:오른쪽, 2:왼쪽
            int y = Integer.parseInt(st.nextToken()); // y칸 밀기

            push(f, x, y);

            for (int j = 0; j < m; j++) {
                bw.write(sequenceArray[f][j] + " ");
            }

            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void push(int f, int x, int y) {
        if (x == 1) {
            for (int i = 0; i < y; i++) {
                int temp = sequenceArray[f][m - 1];

                for (int j = m - 1; j >= 1; j--) {
                    sequenceArray[f][j] = sequenceArray[f][j - 1];
                }

                sequenceArray[f][0] = temp;
            }
        } else {
            for (int i = 0; i < y; i++) {
                int temp = sequenceArray[f][0];

                for (int j = 0; j < m - 1; j++) {
                    sequenceArray[f][j] = sequenceArray[f][j + 1];
                }

                sequenceArray[f][m - 1] = temp;
            }
        }
    }

}
