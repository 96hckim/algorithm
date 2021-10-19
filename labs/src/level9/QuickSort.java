package level9;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class QuickSort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> initList = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            initList.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> mergedList = quickSort(initList);

        for (int num : mergedList) {
            bw.write(num + " ");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static ArrayList<Integer> quickSort(ArrayList<Integer> sortTargetList) {

        if (sortTargetList.size() <= 1) {
            return sortTargetList;
        }

        int pivot = sortTargetList.get(0);

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        for (int i = 1; i < sortTargetList.size(); i++) {
            int compareValue = sortTargetList.get(i);

            if (pivot > compareValue) {
                leftList.add(compareValue);
            } else {
                rightList.add(compareValue);
            }
        }

        ArrayList<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(quickSort(leftList));
        mergedList.add(pivot);
        mergedList.addAll(quickSort(rightList));

        return mergedList;

    }

}
