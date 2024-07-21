package Level6;

import java.io.*;

public class FlipString {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(br.readLine());
        sb.reverse();
        bw.write(sb.toString());

        // 또는
//        String reverseString = sb.reverse().toString();
//        bw.write(reverseString);

        br.close();
        bw.flush();
        bw.close();

    }

}
