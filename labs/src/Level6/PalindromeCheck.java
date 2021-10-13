package Level6;

import java.io.*;
import java.util.HashMap;

public class PalindromeCheck {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(br.readLine());
        String forwardString = sb.toString();
        String reverseString = sb.reverse().toString();

        if (forwardString.equals(reverseString)) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
