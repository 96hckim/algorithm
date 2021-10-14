package Level6;

import java.io.*;

public class MulLargeDigits {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");

        int[] arrA = new int[a.length];
        int[] arrB = new int[b.length];
        int[] result = new int[a.length + b.length];

        // int 변환 후 거꾸로 배열 초기화
        for (int i = a.length - 1; i >= 0; i--) {
            arrA[a.length - 1 - i] = Integer.parseInt(a[i]);
        }

        for (int i = b.length - 1; i >= 0; i--) {
            arrB[b.length - 1 - i] = Integer.parseInt(b[i]);
        }

        // 각 자릿수 곱셈
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += arrA[i] * arrB[j];
            }
        }

        // 각 자릿수 10 넘으면 1의 자릿수만 남기고 다음 자릿수를 몫만큼 올림
        for (int i = 0; i < result.length; i++) {
            if (i < result.length - 1 && result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }

        // 앞의 빈 공간(0) 제외한 시작 인덱스 값
        int startIndex = result.length - 1;
        while (result[startIndex] == 0) {
            startIndex--;
        }

        // 출력
        for (int i = startIndex; i >= 0; i--) {
            bw.write(result[i] + "");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
