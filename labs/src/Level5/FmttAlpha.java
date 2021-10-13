package Level5;

import java.io.*;
import java.util.StringTokenizer;

public class FmttAlpha {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int distance = y - x;

        int move = 1;
        int sum = 0;
        int flag = 0;
        int count = 0;

        while (sum < distance) {
            count++;

            sum += move;

            if (flag == 0) {
                flag = 1;
            } else {
                move++;
                flag = 0;
            }
        }

        bw.write(count + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
