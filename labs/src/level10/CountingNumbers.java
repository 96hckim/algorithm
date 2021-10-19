package level10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CountingNumbers {

    private static ArrayList<Integer> searchTargetList;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        searchTargetList = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            searchTargetList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(searchTargetList);

        ArrayList<Integer> searchItemList = new ArrayList<>(q);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            searchItemList.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < q; i++) {
            int numbers = countEqualNumbers(searchItemList.get(i));
            bw.write(numbers + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static int countEqualNumbers(int searchItem) {

        if (searchTargetList.size() == 1 && searchItem != searchTargetList.get(0)) {
            return 0;
        }

        if (searchTargetList.size() == 1 && searchItem == searchTargetList.get(0)) {
            return 1;
        }

        count = 0;
        int start = 0;
        int end = searchTargetList.size() - 1;

        while (true) {

            if (start > end) {
                return 0;
            }

            if (start == end) {
                if (searchTargetList.get(start) == searchItem) return 1;
                else return 0;
            }

            int medianIndex = (start + end) / 2;
            int medianValue = searchTargetList.get(medianIndex);

            if (searchItem == medianValue) {
                count++;
                findNext(searchItem, medianIndex + 1);
                findPrevious(searchItem, medianIndex - 1);
                return count;
            } else {
                if (searchItem < medianValue) {
                    end = medianIndex - 1;
                } else {
                    start = medianIndex + 1;
                }
            }

        }

    }

    private static void findNext(int searchItem, int index) {
        if (index >= searchTargetList.size()) return;

        if (searchTargetList.get(index) == searchItem) {
            count++;
            findNext(searchItem, index + 1);
        }
    }

    private static void findPrevious(int searchItem, int index) {
        if (index < 0) return;

        if (searchTargetList.get(index) == searchItem) {
            count++;
            findPrevious(searchItem, index - 1);
        }
    }

}
