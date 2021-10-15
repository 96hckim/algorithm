package Special.rotatingtower.push;

import java.io.*;
import java.util.StringTokenizer;

public class SimplePush {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] sequenceArray = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequenceArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i >= 1; i--) {
            sequenceArray[i] = sequenceArray[i - 1];
        }

        sequenceArray[0] = 0;

        for (int i = 0; i < n; i++) {
            bw.write(sequenceArray[i] + " ");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
