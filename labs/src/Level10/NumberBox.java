package Level10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class NumberBox {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> searchTargetList = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            searchTargetList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(searchTargetList);

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> searchItemList = new ArrayList<>(m);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            searchItemList.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            bw.write(isInTheBox(searchTargetList, searchItemList.get(i)) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static int isInTheBox(ArrayList<Integer> searchTargetList, int searchItem) {

        if (searchTargetList.size() == 1 && searchItem != searchTargetList.get(0)) {
            return 0;
        }

        if (searchTargetList.size() == 1 && searchItem == searchTargetList.get(0)) {
            return 1;
        }

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
                return 1;
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
