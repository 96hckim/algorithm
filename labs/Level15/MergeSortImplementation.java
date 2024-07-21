package Level15;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MergeSortImplementation {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>(n);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> sortedList = mergeSort(arrayList);

        for (int num : sortedList) {
            bw.write(num + " ");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static ArrayList<Integer> mergeSort(ArrayList<Integer> arrayList) {

        if (arrayList.size() <= 1) return arrayList;

        int mid = arrayList.size() / 2;

        ArrayList<Integer> leftList = mergeSort(new ArrayList<>(arrayList.subList(0, mid)));
        ArrayList<Integer> rightList = mergeSort(new ArrayList<>(arrayList.subList(mid, arrayList.size())));

        return merge(leftList, rightList);

    }

    private static ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {

        ArrayList<Integer> mergeList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftList.size() > leftIndex && rightList.size() > rightIndex) {
            int leftValue = leftList.get(leftIndex);
            int rightValue = rightList.get(rightIndex);

            if (leftValue < rightValue) {
                mergeList.add(leftValue);
                leftIndex++;
            } else {
                mergeList.add(rightValue);
                rightIndex++;
            }
        }

        while (leftList.size() > leftIndex) {
            mergeList.add(leftList.get(leftIndex));
            leftIndex++;
        }

        while (rightList.size() > rightIndex) {
            mergeList.add(rightList.get(rightIndex));
            rightIndex++;
        }

        return mergeList;

    }

}
