package Level4;

import java.io.*;
import java.util.StringTokenizer;

public class Seat {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int myNumber = Integer.parseInt(br.readLine());

        int maxNumber = r * c;

        if (myNumber > maxNumber) {
            System.out.println("0");
            return;
        }

        int[][] concertArray = new int[r + 2][c + 2];
        for (int i = 0; i < concertArray.length; i++) {
            concertArray[i][0] = 1;
            concertArray[i][concertArray[0].length - 1] = 1;
        }

        for (int i = 0; i < concertArray[0].length; i++) {
            concertArray[0][i] = 1;
            concertArray[concertArray.length - 1][i] = 1;
        }

        int currentX = 1;
        int currentY = 1;
        int waitNumber = 1;

        int[] directX = {0, 1, 0, -1};
        int[] directY = {1, 0, -1, 0};
        int direction = 0;

        while (waitNumber < maxNumber) {
            if (waitNumber == myNumber) {
                break;
            }

            concertArray[currentX][currentY] = 1;

            int nextX = currentX + directX[direction];
            int nextY = currentY + directY[direction];

            if (concertArray[nextX][nextY] == 1) {
                direction = (direction + 1) % 4;
            }

            currentX = currentX + directX[direction];
            currentY = currentY + directY[direction];

            waitNumber++;
        }

        bw.write(currentX + " " + currentY);

        br.close();
        bw.flush();
        bw.close();

    }

}
