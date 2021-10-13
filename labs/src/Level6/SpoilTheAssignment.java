package Level6;

import java.io.*;
import java.util.StringTokenizer;

public class SpoilTheAssignment {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            bw.write(st.nextToken());
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
