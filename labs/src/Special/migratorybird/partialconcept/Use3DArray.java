package Special.migratorybird.partialconcept;

import java.util.Scanner;

public class Use3DArray {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int q = scan.nextInt();
        int[][][] map = new int[N + 1][M + 1][q];
        int[][] size = new int[N + 1][M + 1];

        for (int i = 0; i < q; i++) {

            int t = scan.nextInt();
            int y = scan.nextInt();
            int x = scan.nextInt();
            int w = t <= 2 ? scan.nextInt() : 0;

            switch (t) {
                case 1:
                    map[y][x][size[y][x]++] = w;
                    break;
                case 2:
                    for (int j = size[y][x]; j > 0; j--) map[y][x][j] = map[y][x][j - 1];
                    map[y][x][0] = w;
                    size[y][x]++;
                    break;
                case 3:
                    size[y][x]--;
                    map[y][x][size[y][x]] = 0;
                    break;
                case 4:
                    System.out.println(map[y][x][size[y][x] - 1]);
                    break;
            }

        }

    }

}
