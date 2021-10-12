package Level5;

import java.io.*;
import java.util.StringTokenizer;

public class PROSJEK {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] sequenceArray = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sequenceArray[i] = Integer.parseInt(st.nextToken());
        }

        int prevSum = 0;
        for (int i = 1; i <= n; i++) {
            int num = sequenceArray[i] * i - prevSum;
            prevSum += num;
            bw.write(num + " ");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
