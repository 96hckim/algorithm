package basic_part_1.data_structure_200;

import java.io.*;

public class Bracket_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] data = br.readLine().toCharArray();
            int count = 0;

            for (char c : data) {
                switch (c) {
                    case '(':
                        count++;
                        break;
                    case ')':
                        count--;
                        break;
                }

                if (count < 0) {
                    break;
                }
            }

            if (count == 0) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
