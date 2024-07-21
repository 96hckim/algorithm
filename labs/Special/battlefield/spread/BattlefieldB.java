package Special.battlefield.spread;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Coordinate {

    private int y;
    private int x;

    public Coordinate(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}

public class BattlefieldB {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        Coordinate currentPosition = null;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value > 0) {
                    if (value != 9) coordinates.add(new Coordinate(i, j));
                    else {
                        if (currentPosition == null) currentPosition = new Coordinate(i, j);
                        else coordinates.add(new Coordinate(i, j));
                    }
                }
            }
        }

        for (Coordinate coordinate : coordinates) {
            arr[coordinate.getY()][coordinate.getX()] = Math.abs(currentPosition.getY() - coordinate.getY()) + Math.abs(currentPosition.getX() - coordinate.getX());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (currentPosition.getY() == i && currentPosition.getX() == j) bw.write("* ");
                else bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
