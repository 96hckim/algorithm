package Level5;

import java.io.*;
import java.util.StringTokenizer;

public class NextNum {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            if (num1 == 0 && num2 == 0 && num3 == 0) {
                break;
            }

            if (num2 - num1 == num3 - num2) {
                bw.write("AP " + (num3 + num2 - num1));
            } else {
                bw.write("GP " + (num3 * num2 / num1));
            }

            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
