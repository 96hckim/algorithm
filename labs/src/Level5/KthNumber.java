package Level5;

import java.io.*;
import java.util.StringTokenizer;

public class KthNumber {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {

            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;

            if (i == k - 1) {
                bw.write(arr[i] + "");
                break;
            }

        }

        br.close();
        bw.flush();
        bw.close();

    }

}
