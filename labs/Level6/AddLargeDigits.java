package Level6;

import java.io.*;

public class AddLargeDigits {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        int n = Math.max(a.length(), b.length());

        int[] arrA = new int[n + 1];
        int[] arrB = new int[n + 1];

        for (int i = n, length = a.length() - 1; length >= 0; i--, length--) {
            arrA[i] = Character.getNumericValue(a.charAt(length));
        }

        for (int i = n, length = b.length() - 1; length >= 0; i--, length--) {
            arrB[i] = Character.getNumericValue(b.charAt(length));
        }

        int[] addResult = new int[n + 1];

        for (int i = n; i > 0; i--) {
            int addValue = arrA[i] + arrB[i] + addResult[i];
            int q = addValue / 10;
            int r = addValue % 10;

            addResult[i] = r; // 현재 자리 숫자
            if (q > 0) addResult[i - 1] += q; // 다음 자릿수 +1
        }

        if (addResult[0] > 0) {
            bw.write(addResult[0] + "");
        }
        for (int i = 1; i < addResult.length; i++) {
            bw.write(addResult[i] + "");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
