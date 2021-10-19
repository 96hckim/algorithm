package level10;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BinarySearch {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int searchItem = Integer.parseInt(st.nextToken());

            if (binarySearch(arr, searchItem)) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }

            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static boolean binarySearch(ArrayList<Integer> searchTargetList, int searchItem) {

        if (searchTargetList.size() == 0) {
            return false;
        }

        if (searchTargetList.size() == 1 && searchItem != searchTargetList.get(0)) {
            return false;
        }

        if (searchTargetList.size() == 1 && searchItem == searchTargetList.get(0)) {
            return true;
        }

        int start = 0;
        int end = searchTargetList.size() - 1;

        while (true) {

            if (start > end) {
                return false;
            }

            if (start == end) {
                return searchTargetList.get(start) == searchItem;
            }

            int medianIndex = (start + end) / 2;
            int medianValue = searchTargetList.get(medianIndex);

            if (searchItem == medianValue) {
                return true;
            } else {
                if (searchItem < medianValue) {
                    end = medianIndex - 1;
                } else {
                    start = medianIndex + 1;
                }
            }

        }

    }

}
