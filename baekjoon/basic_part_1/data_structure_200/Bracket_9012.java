package basic_part_1.data_structure_200;

import java.io.*;

public class Bracket_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            char[] brackets = line.toCharArray();
            int bracketCount = 0;

            for (char bracket : brackets) {
                switch (bracket) {
                    case '(' -> bracketCount++;
                    case ')' -> bracketCount--;
                }
                if (bracketCount < 0) break;
            }

            bw.write(bracketCount == 0 ? "YES" : "NO");
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
