package Level16;

import java.io.*;

public class MarbleGame {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String result = n % 4 == 0 ? "NO" : "YES";

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();

    }

}
