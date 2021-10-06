package Level3;

import java.io.*;
import java.util.StringTokenizer;

public class Offset {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int row = 5;
        int column = 5;

        String[][] arr = new String[row][column];

        for (int i = 0; i < row; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < row; i++) {
            int bottom = i + 1;
            int top = i - 1;

            for (int j = 0; j < column; j++) {
                int count = 0;
                int currentValue = Integer.parseInt(arr[i][j]);
                int left = j - 1;
                int right = j + 1;

                if (bottom < row) {
                    if (!arr[bottom][j].equals("*")) {
                        if (currentValue < Integer.parseInt(arr[bottom][j])) {
                            count++;
                        }
                    }
                } else {
                    count++;
                }

                if (top >= 0) {
                    if (!arr[top][j].equals("*")) {
                        if (currentValue < Integer.parseInt(arr[top][j])) {
                            count++;
                        }
                    }
                } else {
                    count++;
                }

                if (right < column) {
                    if (!arr[i][right].equals("*")) {
                        if (currentValue < Integer.parseInt(arr[i][right])) {
                            count++;
                        }
                    }
                } else {
                    count++;
                }

                if (left >= 0) {
                    if (!arr[i][left].equals("*")) {
                        if (currentValue < Integer.parseInt(arr[i][left])) {
                            count++;
                        }
                    }
                } else {
                    count++;
                }

                if (count == 4) {
                    arr[i][j] = "*";
                }

                bw.write(arr[i][j] + " ");
            }

            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
