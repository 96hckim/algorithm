package Level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutation {

    private static char[] resultArray;
    private static boolean[] useAlphabetArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        resultArray = new char[15];
        useAlphabetArray = new boolean[15];

        permutation(0, n, r);

    }

    private static void permutation(int x, int n, int r) {

        if (x >= r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(resultArray[i]);
            }
            System.out.println(sb);
        } else {

            for (int i = 0; i < n; i++) {
                char alphabet = (char) ('a' + i);

                if (!useAlphabetArray[i]) {
                    resultArray[x] = alphabet;
                    useAlphabetArray[i] = true;
                    permutation(x + 1, n, r);
                    resultArray[x] = 0;
                    useAlphabetArray[i] = false;
                }
            }
        }

    }

}
