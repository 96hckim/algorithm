package Special.rotatingtower.inquiry;

import java.io.*;
import java.util.StringTokenizer;

public class TwoDimensionalInquiry {

    private static int n, m;
    private static int[][] sequenceArray;
    private static int[][] resultArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sequenceArray = new int[n + 2][m + 2];
        resultArray = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                sequenceArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < sequenceArray.length; i++) {
            sequenceArray[i][0] = sequenceArray[i][sequenceArray[0].length - 1] = -1;
        }

        for (int i = 0; i < sequenceArray[0].length; i++) {
            sequenceArray[0][i] = sequenceArray[sequenceArray.length - 1][i] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (sequenceArray[i][j] == sequenceArray[i - 1][j] ||
                        sequenceArray[i][j] == sequenceArray[i + 1][j] ||
                        sequenceArray[i][j] == sequenceArray[i][j - 1] ||
                        sequenceArray[i][j] == sequenceArray[i][j + 1]) {
                    resultArray[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                bw.write(resultArray[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
