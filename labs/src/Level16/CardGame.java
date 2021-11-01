package Level16;

import java.io.*;
import java.util.StringTokenizer;

public class CardGame {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int card = Integer.parseInt(st.nextToken());

            if (i == 0) {
                arr[0] = 0;
                arr[1] = card;
                arr[2] = 0;
            } else {
                int max = Math.max(arr[0], Math.max(arr[1], arr[2]));
                arr[2] = arr[1] + card;
                arr[1] = arr[0] + card;
                arr[0] = max;
            }
        }

        int result = Math.max(arr[0], Math.max(arr[1], arr[2]));

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
