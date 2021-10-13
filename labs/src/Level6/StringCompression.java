package Level6;

import java.io.*;

public class StringCompression {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(br.readLine());

        char prevChar = sb.charAt(0);
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (prevChar == sb.charAt(i)) {
                count++;
            } else {
                bw.write((count == 1 ? "" : count) + "" + prevChar);
                prevChar = sb.charAt(i);
                count = 1;
            }
        }

        bw.write((count == 1 ? "" : count) + "" + prevChar);

        br.close();
        bw.flush();
        bw.close();

    }

}
