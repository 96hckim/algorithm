package Level19;

import java.io.*;
import java.util.ArrayList;

public class WeirdCalculator {

    private static int[] result = new int[100000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(bfs(n) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int bfs(int n) {

        ArrayList<Integer> needVisit = new ArrayList<>();
        needVisit.add(1);

        while (needVisit.get(0) != n) {

            int num = needVisit.remove(0);

            int mul = num * 2;
            int div = num / 3;

            if (mul <= 99999) {
                if (result[mul] == 0) {
                    needVisit.add(mul);
                    result[mul] = result[num] + 1;
                } else {
                    result[mul] = Math.min(result[mul], result[num] + 1);
                }
            }

            if (div > 0) {
                if (result[div] == 0) {
                    needVisit.add(div);
                    result[div] = result[num] + 1;
                } else {
                    result[div] = Math.min(result[div], result[num] + 1);
                }
            }

        }

        return result[needVisit.get(0)];

    }

}
