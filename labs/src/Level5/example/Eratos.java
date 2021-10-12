package Level5.example;

import java.io.*;
import java.util.Arrays;

/**
 * N 까지 소수 구하기
 */
public class Eratos {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[num + 1];

        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            for (int j = i * i; j <= num; j += i) {
                arr[j] = false;
            }
        }

        for (int i = 0; i <= num; i++) {
            if (arr[i]) {
                bw.write(i + " ");
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
