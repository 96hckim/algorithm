package Level6;

import java.io.*;
import java.util.Arrays;

public class StringSort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] sortArray = new String[n];
        for (int i = 0; i < n; i++) {
            sortArray[i] = br.readLine();
        }

        Arrays.sort(sortArray);

        for (int i = 0; i < n; i++) {
            bw.write(sortArray[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
