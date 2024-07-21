package CompetencyTest.practice;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SLIKAR {

    private static int R;
    private static int C;
    private static int[][] map;

    private static final char EMPTY = '.';
    private static final char WATER = '*';
    private static final char ROCK = 'X';
    private static final char CAVE = 'D';
    private static final char HEDGEHOG = 'S';

    private static Queue<int[]> water;
    private static Queue<int[]> hedgehog;

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static boolean IS_POSSIBLE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        water = new LinkedList<>();
        hedgehog = new LinkedList<>();
        IS_POSSIBLE = false;

        for (int i = 0; i < R; i++) {
            char[] values = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = values[j];
                if (map[i][j] == WATER) water.add(new int[]{i, j});
                else if (map[i][j] == HEDGEHOG) hedgehog.add(new int[]{i, j});
            }
        }

        int count = 0;
        while (!hedgehog.isEmpty() && !IS_POSSIBLE) {
            count++;
            spreadWater();
            moveHedgehog();
        }

        if (IS_POSSIBLE) bw.write(count + "");
        else bw.write("KAKTUS");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void spreadWater() {
        int size = water.size();
        for (int i = 0; i < size; i++) {
            int[] pos = water.poll();
            int y = pos[0];
            int x = pos[1];

            for (int j = 0; j < 4; j++) {
                int ny = y + dy[j];
                int nx = x + dx[j];

                if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if (map[ny][nx] == EMPTY || map[ny][nx] == HEDGEHOG) {
                        map[ny][nx] = WATER;
                        water.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    private static void moveHedgehog() {
        int size = hedgehog.size();
        for (int i = 0; i < size; i++) {
            int[] pos = hedgehog.poll();
            int y = pos[0];
            int x = pos[1];

            for (int j = 0; j < 4; j++) {
                int ny = y + dy[j];
                int nx = x + dx[j];

                if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if (map[ny][nx] == EMPTY) {
                        map[ny][nx] = HEDGEHOG;
                        hedgehog.add(new int[]{ny, nx});
                    } else if (map[ny][nx] == CAVE) {
                        IS_POSSIBLE = true;
                        return;
                    }
                }
            }
        }
    }

}
