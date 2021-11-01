package Level17;

import java.io.*;

public class MakingPalindrome {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] str = br.readLine().toCharArray();
        int[][] arr = new int[str.length][str.length];

        for (int i = str.length - 1; i >= 0; i--) {
            for (int j = i; j < str.length; j++) {
                if (i == j) arr[i][j] = 0;
                else if (str[i] == str[j]) arr[i][j] = arr[i + 1][j - 1];
                else arr[i][j] = Math.min(arr[i + 1][j], arr[i][j - 1]) + 1;
            }
        }

        bw.write(arr[0][str.length - 1] + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
