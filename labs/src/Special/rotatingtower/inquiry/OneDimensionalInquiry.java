package Special.rotatingtower.inquiry;

import java.io.*;
import java.util.StringTokenizer;

public class OneDimensionalInquiry {

    private static int n;
    private static int[] sequenceArray;
    private static int[] resultArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        sequenceArray = new int[n];
        resultArray = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequenceArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            if (sequenceArray[i] == sequenceArray[i + 1]) {
                resultArray[i] = resultArray[i + 1] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(resultArray[i] + " ");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
