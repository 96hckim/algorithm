package Level3;

import java.io.*;
import java.util.StringTokenizer;

public class BoxDecoration {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int paperNumber = Integer.parseInt(br.readLine());

        int[] paperArr = new int[paperNumber + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < paperNumber; i++) {
            paperArr[Integer.parseInt(st.nextToken())]++;
        }

        int count = 0;

        for (int i = 1; i < paperArr.length; i++) {
            count += Math.min(paperArr[i], 2);
        }

        if (count >= 6) bw.write("YES");
        else bw.write("NO");

        br.close();
        bw.flush();
        bw.close();

    }

}
