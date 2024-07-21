package Level5;

import java.io.*;
import java.util.StringTokenizer;

public class CombinationPascal {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bw.write(pascal(n, m) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    static int pascal(int n, int m) {
        if (n == m || m == 0) return 1;

        return pascal(n - 1, m) + pascal(n - 1, m - 1);
    }

}
