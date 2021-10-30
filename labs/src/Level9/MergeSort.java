package Level9;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MergeSort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> initList = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            initList.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> mergedList = mergeSort(initList);

        for (int num : mergedList) {
            bw.write(num + " ");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static ArrayList<Integer> mergeSort(ArrayList<Integer> sortTargetList) {

        if (sortTargetList.size() <= 1) {
            return sortTargetList;
        }

        int median = sortTargetList.size() / 2;

        ArrayList<Integer> leftList = mergeSort(new ArrayList<>(sortTargetList.subList(0, median)));
        ArrayList<Integer> rightList = mergeSort(new ArrayList<>(sortTargetList.subList(median, sortTargetList.size())));

        return merging(leftList, rightList);

    }

    private static ArrayList<Integer> merging(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {

        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        // left, right 데이터 둘 다 있을 때
        while (leftList.size() > leftIndex && rightList.size() > rightIndex) {
            int leftValue = leftList.get(leftIndex);
            int rightValue = rightList.get(rightIndex);

            if (leftValue > rightValue) {
                mergedList.add(rightValue);
                rightIndex++;
            } else {
                mergedList.add(leftValue);
                leftIndex++;
            }
        }

        // right 데이터가 없을 때
        while (leftList.size() > leftIndex) {
            mergedList.add(leftList.get(leftIndex));
            leftIndex++;
        }

        // left 데이터가 없을 때
        while (rightList.size() > rightIndex) {
            mergedList.add(rightList.get(rightIndex));
            rightIndex++;
        }

        return mergedList;

    }

}
