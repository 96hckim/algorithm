package Level5.example;

import java.io.*;

/**
 * 삽입정렬 : 원소를 차례대로 정렬된 배열에 삽입시킴
 */
public class InsertionSort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = {1, 4, 2, 5};

        for (int i = 1; i < arr.length; i++) {

            int target = arr[i];
            int currentPosition = i;

            while (currentPosition > 0 && arr[currentPosition - 1] > target) {
                arr[currentPosition] = arr[currentPosition - 1];
                currentPosition--;
            }

            arr[currentPosition] = target;

        }

        for (int num : arr) {
            bw.write(num + " ");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
