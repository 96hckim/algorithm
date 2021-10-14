package Level6;

import java.io.*;

public class SubLargeDigits {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        String bigNumber = a; // 둘 중 큰 수
        String smallNumber = b; // 작은수
        boolean isMinus = false; // 음수인지 판별 플래그값

        if (a.length() < b.length()) {
            bigNumber = b;
            smallNumber = a;
            isMinus = true;
        } else if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                int numberA = a.charAt(i) - '0';
                int numberB = b.charAt(i) - '0';

                if (numberA == numberB) continue;
                else if (numberA < numberB) {
                    bigNumber = b;
                    smallNumber = a;
                    isMinus = true;
                }

                break;
            }
        }

        int n = bigNumber.length();

        int[] bigArray = new int[n];
        int[] smallArray = new int[n];

        // 두 수 자릿수 맞추어 초기화
        for (int i = n - 1, length = bigNumber.length() - 1; length >= 0; i--, length--) {
            bigArray[i] = bigNumber.charAt(length) - '0';
        }

        for (int i = n - 1, length = smallNumber.length() - 1; length >= 0; i--, length--) {
            smallArray[i] = smallNumber.charAt(length) - '0';
        }

        // 연산 결과 배열
        int[] subResult = new int[n];

        // 계산
        for (int i = n - 1; i >= 0; i--) {
            int subValue = bigArray[i] - smallArray[i] + subResult[i];
            int currentValue = subValue;
            int nextValue = 0;

            if (subValue < 0) {
                currentValue += 10;
                nextValue = -1;
            }

            subResult[i] = currentValue;
            if (i > 0) subResult[i - 1] = nextValue;
        }

        // 출력
        if (isMinus) {
            bw.write("-");
        }

        int startIndex = 0;

        for (int i = 0; i < subResult.length; i++) {
            if (subResult[i] == 0) {
                startIndex = i + 1;
            } else {
                break;
            }
        }

        if (startIndex == subResult.length) {
            bw.write("0");
        } else {
            for (int i = startIndex; i < subResult.length; i++) {
                bw.write(subResult[i] + "");
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
