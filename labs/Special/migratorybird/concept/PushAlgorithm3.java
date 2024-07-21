package Special.migratorybird.concept;

import java.util.Scanner;

public class PushAlgorithm3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int q = scan.nextInt();

        int[][][] map = new int[N + 1][M + 1][q * 10];
        int[][] size = new int[N + 1][M + 1];

        for (int i = 0; i < q; i++) {

            int t = scan.nextInt();
            int y = scan.nextInt();
            int x = scan.nextInt();
            int w = t <= 2 ? scan.nextInt() : 0;
            int c = t <= 3 ? scan.nextInt() : 0;

            switch (t) {
                case 1:
                    for (int j = 0; j < c; j++) map[y][x][size[y][x]++] = w;
                    break;
                case 2:
                    size[y][x] += c;
                    for (int j = size[y][x] - 1; j >= c; j--) {
                        int prevIndex = j - c;
                        if (prevIndex >= 0) map[y][x][j] = map[y][x][prevIndex];
                    }
                    for (int j = 0; j < c; j++) map[y][x][j] = w;
                    break;
                case 3:
                    for (int j = 0; j < c; j++) map[y][x][--size[y][x]] = 0;
                    break;
                case 4:
                    System.out.println(map[y][x][size[y][x] - 1]);
                    break;
            }

        }


    }

}
