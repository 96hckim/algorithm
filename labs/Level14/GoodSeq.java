package Level14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodSeq {

    private static boolean isFinish = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        goodSeq(new int[n], 0, n);

        br.close();

    }

    private static void goodSeq(int[] resultArray, int x, int n) {

        if (isFinish) return;

        if (x == n) {

            for (int result : resultArray) {
                System.out.print(result + "");
            }

            isFinish = true;

        } else {

            number:
            for (int i = 1; i <= 3; i++) {

                resultArray[x] = i;

                for (int j = 1; j <= (x + 1) / 2; j++) {
                    if (!isAvailable(resultArray, x, j)) continue number;
                }

                goodSeq(resultArray, x + 1, n);

            }

        }

    }

    private static boolean isAvailable(int[] resultArray, int x, int length) {

        for (int i = 0; i < length; i++) {
            if (resultArray[x - i] != resultArray[x - i - length]) return true;
        }

        return false;

    }

}
