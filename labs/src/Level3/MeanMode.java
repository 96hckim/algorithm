package Level3;

import java.io.*;

public class MeanMode {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int[] modeArr = new int[101];

        for (int i = 0; i < 10; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            modeArr[value / 10]++;
        }

        int mean = sum / 10;

        int maxIndex = 0;
        for (int i = 0; i < modeArr.length; i++) {
            if (modeArr[i] > modeArr[maxIndex]) {
                maxIndex = i;
            }
        }

        int mode = maxIndex * 10;

        bw.write(mean + "\n" + mode);

        bw.flush();
        bw.close();

    }

}
