package Level4;

import java.io.*;
import java.util.StringTokenizer;

public class Tetris {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        String[][] tetrisArray = new String[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                tetrisArray[i][j] = st.nextToken();
            }
        }

        String highestScore = "0 0";

        for (int i = 0; i < c; i++) {

            int emptyCount = 0;
            int score = 0;

            for (int j = 0; j < r; j++) {

                if (tetrisArray[j][i].equals("0")) {

                    if (j == r - 1) {
                        score = countScore(tetrisArray, j, i);
                    } else {
                        emptyCount++;
                    }

                } else if (tetrisArray[j][i].equals("1")) {

                    if (emptyCount >= 4) {
                        score = countScore(tetrisArray, j - 1, i);
                    }

                    break;

                }

            }

            if (score > Integer.parseInt(highestScore.substring(highestScore.length() - 1))) {
                highestScore = (i + 1) + " " + score;
            }

        }

        bw.write(highestScore);

        br.close();
        bw.flush();
        bw.close();

    }

    static int countScore(String[][] tetrisArray, int x, int y) {

        int horizontalCount = 0;
        int score = 0;


        String[][] tetrisCopyArray = new String[tetrisArray.length][tetrisArray[0].length];
        for (int i = 0; i < tetrisArray.length; i++) {
            tetrisCopyArray[i] = tetrisArray[i].clone();
        }

        for (int i = x; i > x - 4; i--) {
            tetrisCopyArray[i][y] = "1";
        }

        for (int i = 0; i < tetrisArray.length; i++) {
            for (int j = 0; j < tetrisArray[0].length; j++) {
                if (tetrisCopyArray[i][j].equals("1")) {
                    horizontalCount++;
                }
            }

            if (horizontalCount == tetrisArray[0].length) {
                score++;
            }

            horizontalCount = 0;
        }

        return score;

    }

}
