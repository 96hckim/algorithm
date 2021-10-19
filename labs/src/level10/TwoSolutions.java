package level10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class TwoSolutions {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> solutions = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            solutions.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(solutions);

        int start = 0;
        int end = solutions.size() - 1;
        int min = Integer.MAX_VALUE;
        int result1 = 0;
        int result2 = 0;

        while (start < end) {

            int sum = solutions.get(start) + solutions.get(end);

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);

                result1 = solutions.get(start);
                result2 = solutions.get(end);

                if (sum == 0) break;
            }

            if (sum < 0) start++;
            else end--;

        }

        bw.write(result1 + " " + result2);

        br.close();
        bw.flush();
        bw.close();

    }

}
