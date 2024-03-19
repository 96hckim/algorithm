package basic_part_2.brute_force_520;

import java.io.*;
import java.util.StringTokenizer;

public class NextPermutation_10972 {
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        if (hasNextPermutation()) {
            for (int num : input) {
                bw.write(num + " ");
            }
        } else {
            bw.write("-1");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean hasNextPermutation() {
        int i = input.length - 1;
        // 1. A[i-1] < A[i] 를 만족하는 가장 큰 i를 찾는다.
        while (i > 0 && input[i - 1] >= input[i]) {
            i--;
        }

        // i의 위치가 0이면 내림차순(마지막 순열)
        if (i <= 0) {
            return false;
        }

        int j = input.length - 1;
        // 2. j >= i 이면서 A[j] > A[i-1] 을 만족하는 가장 큰 j를 찾는다.
        while (input[i - 1] >= input[j]) {
            j--;
        }

        // 3. A[i-1]과 A[j] 를 swap 한다.
        swap(i - 1, j);

        j = input.length - 1;
        // 4. A[i] 부터 순열을 뒤집는다.
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    static void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
