package Level5;

import java.io.*;
import java.util.Arrays;

public class Eratos {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[1001];

        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;

        for (int i = 2; i <= Math.sqrt(arr.length - 1); i++) {
            for (int j = i * i; j <= arr.length - 1; j += i) {
                arr[j] = false;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                bw.write(i + " ");
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
