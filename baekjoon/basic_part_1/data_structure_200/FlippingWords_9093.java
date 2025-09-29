package basic_part_1.data_structure_200;

import java.io.*;
import java.util.StringTokenizer;

public class FlippingWords_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                String reversed = new StringBuilder(word).reverse().toString();
                bw.write(reversed + " ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
