package Special.aircleaner.spread;

import java.io.*;
import java.util.StringTokenizer;

public class OneDSpread {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            answer[i] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                if (i - 1 >= 0) answer[i - 1] = 1;
                if (i + 1 < n) answer[i + 1] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(answer[i] + " ");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
