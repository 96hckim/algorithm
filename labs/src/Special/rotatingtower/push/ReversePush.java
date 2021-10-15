package Special.rotatingtower.push;

import java.io.*;
import java.util.StringTokenizer;

public class ReversePush {

    private static int n, k;
    private static int[] sequenceArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        sequenceArray = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequenceArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            push();
        }

        for (int i = 0; i < n; i++) {
            bw.write(sequenceArray[i] + " ");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void push() {
        int temp = sequenceArray[0];

        for (int j = 0; j <= n - 2; j++) {
            sequenceArray[j] = sequenceArray[j + 1];
        }

        sequenceArray[n - 1] = temp;
    }

}
