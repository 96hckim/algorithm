package Level3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ClassPresident {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] classArr = new int[n][5];

        ArrayList<Integer> countList = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                classArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (classArr[i][0] == classArr[j][0] ||
                        classArr[i][1] == classArr[j][1] ||
                        classArr[i][2] == classArr[j][2] ||
                        classArr[i][3] == classArr[j][3] ||
                        classArr[i][4] == classArr[j][4]) {
                    countList.set(i, countList.get(i) + 1);
                    countList.set(j, countList.get(j) + 1);
                }
            }
        }

        int maxValue = Collections.max(countList);
        int maxIndex = countList.indexOf(maxValue);

        bw.write(String.valueOf(maxIndex + 1));

        br.close();
        bw.flush();
        bw.close();

    }

}
