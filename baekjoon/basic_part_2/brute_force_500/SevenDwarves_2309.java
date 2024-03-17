package basic_part_2.brute_force_500;

import java.io.*;
import java.util.Arrays;

public class SevenDwarves_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] heights = new int[9];

        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            heights[i] = height;
        }

        int[] results = new int[7];

        for (int i = 0; i <= 2; i++) {
            for (int j = i + 1; j <= 3; j++) {
                for (int k = j + 1; k <= 4; k++) {
                    for (int l = k + 1; l <= 5; l++) {
                        for (int m = l + 1; m <= 6; m++) {
                            for (int n = m + 1; n <= 7; n++) {
                                for (int o = n + 1; o <= 8; o++) {
                                    if (heights[i] + heights[j] + heights[k] + heights[l] + heights[m] + heights[n] + heights[o] == 100) {
                                        results[0] = heights[i];
                                        results[1] = heights[j];
                                        results[2] = heights[k];
                                        results[3] = heights[l];
                                        results[4] = heights[m];
                                        results[5] = heights[n];
                                        results[6] = heights[o];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Arrays.sort(results);

        for (int result : results) {
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
