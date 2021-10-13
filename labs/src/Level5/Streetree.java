package Level5;

import java.io.*;
import java.util.ArrayList;

public class Streetree {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> trees = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            trees.add(Integer.parseInt(br.readLine()));
        }

        int gcd = trees.get(1) - trees.get(0);

        for (int i = 1; i < n - 1; i++) {
            int distance = trees.get(i + 1) - trees.get(i);

            gcd = gcd(distance, gcd);
        }

        int count = (trees.get(n - 1) - trees.get(0)) / gcd - n + 1;

        bw.write(count + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

}
