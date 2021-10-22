package level10;

import java.io.*;
import java.util.StringTokenizer;

public class CuttingTrees {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;

        int[] treeArray = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeArray[i] = Integer.parseInt(st.nextToken());

            if (treeArray[i] > max) {
                max = treeArray[i];
            }
        }

        int h = binarySearch(treeArray, m, max);

        bw.write(h + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int binarySearch(int[] treeArray, int m, int max) {

        int start = 0;
        int end = max;

        while (start + 1 < end) {

            int mid = (start + end) / 2;
            long sum = 0;

            for (int tree : treeArray) {
                int cuttingTree = tree - mid;
                if (cuttingTree > 0) sum += cuttingTree;
            }

            if (sum < m) end = mid;
            else if (sum > m) start = mid;
            else return mid;

        }

        return start;

    }

}
