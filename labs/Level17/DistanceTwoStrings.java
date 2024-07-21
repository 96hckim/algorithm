package Level17;

import java.io.*;

public class DistanceTwoStrings {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        int[][] arr = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            arr[i][0] = i;
        }

        for (int i = 0; i <= b.length(); i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) arr[i][j] = arr[i - 1][j - 1];
                else arr[i][j] = Math.min(arr[i][j - 1], arr[i - 1][j]) + 1;
            }
        }

        bw.write(arr[a.length()][b.length()] + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
