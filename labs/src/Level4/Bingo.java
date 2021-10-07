package Level4;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Bingo {

    private static boolean LeftToRightIsBingo = false;
    private static boolean RightToLeftIsBingo = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] bingoArr = new String[5][5];

        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingoArr[i][j] = st.nextToken();
            }
        }

        ArrayList<String> sequenceList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                sequenceList.add(st.nextToken());
            }
        }

        int bingoCount = 0;

        all:
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (Objects.equals(bingoArr[j][k], sequenceList.get(i))) {
                        bingoArr[j][k] = "x";

                        bingoCount += bingoInPoints(bingoArr, j, k);

                        if (bingoCount >= 3) {
                            bw.write((i + 1) + "");
                            break all;
                        }
                    }
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

    static int bingoInPoints(String[][] bingoArr, int x, int y) {

        int bingoCount = 0;
        int XCount = 0;

        // 가로
        for (int i = 0; i < 5; i++) {
            if (Objects.equals(bingoArr[x][i], "x")) {
                XCount++;
            }
        }

        if (XCount == 5) {
            bingoCount++;
        }

        XCount = 0;

        // 세로
        for (int i = 0; i < 5; i++) {
            if (Objects.equals(bingoArr[i][y], "x")) {
                XCount++;
            }
        }

        if (XCount == 5) {
            bingoCount++;
        }

        // 좌 -> 우 대각선
        if (!LeftToRightIsBingo) {
            if (bingoArr[0][0].equals("x") &&
                    bingoArr[1][1].equals("x") &&
                    bingoArr[2][2].equals("x") &&
                    bingoArr[3][3].equals("x") &&
                    bingoArr[4][4].equals("x")) {
                LeftToRightIsBingo = true;
                bingoCount++;
            }
        }

        // 우 -> 좌 대각선선
        if (!RightToLeftIsBingo) {
            if (bingoArr[0][4].equals("x") &&
                    bingoArr[1][3].equals("x") &&
                    bingoArr[2][2].equals("x") &&
                    bingoArr[3][1].equals("x") &&
                    bingoArr[4][0].equals("x")) {
                RightToLeftIsBingo = true;
                bingoCount++;
            }
        }

        return bingoCount;

    }

}
