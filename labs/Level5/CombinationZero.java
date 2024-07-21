package Level5;

import java.io.*;
import java.util.StringTokenizer;

public class CombinationZero {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // nCm은 수식으로 n!/m!(n-m)! 으로 구할 수 있다. (5! = 12345)
        // 2, 5 갯수 구하기
        int top2 = count2or5(n, 2);
        int bot2 = count2or5(m, 2) + count2or5(n - m, 2);

        int top5 = count2or5(n, 5);
        int bot5 = count2or5(m, 5) + count2or5(n - m, 5);

        int count2 = top2 - bot2;
        int count5 = top5 - bot5;

        bw.write(Math.min(count2, count5) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int count2or5(int num, int refVal) {
        int count = 0;

        while (num > 0) {
            num /= refVal;
            count += num;
        }

        return count;
    }

}
