package src;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CowCrossingCounter_14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] lastPos = new int[11];  // 소 번호 1~10
        int initialPos = -1;
        Arrays.fill(lastPos, initialPos);

        int crossings = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (lastPos[cow] == initialPos) {
                lastPos[cow] = pos; // 첫 관찰
            } else {
                if (lastPos[cow] != pos) {
                    crossings++;
                    lastPos[cow] = pos;
                }
            }
        }

        bw.write(String.valueOf(crossings));

        bw.flush();
        br.close();
        bw.close();
    }
}
