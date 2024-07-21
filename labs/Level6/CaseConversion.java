package Level6;

import java.io.*;

public class CaseConversion {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] charArray = br.readLine().toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if (Character.isUpperCase(c)) {
                charArray[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                charArray[i] = Character.toUpperCase(c);
            }

            bw.write(charArray[i]);
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
