package Level5;

import java.io.*;

/**
 * 선택정렬 : 최솟값을 앞으로 이동시킴
 */
public class SelectionSort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = {1, 4, 2, 5};

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }

        for (int num : arr) {
            bw.write(num + " ");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
