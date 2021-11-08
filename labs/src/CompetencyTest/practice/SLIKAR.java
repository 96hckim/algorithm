package CompetencyTest.practice;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SLIKAR {

    private static int R; // 행
    private static int C; // 열
    private static char[][] forest; // 숲 배열

    private static final char EMPTY = '.'; // 비어있는 곳
    private static final char WATER = '*'; // 물
    private static final char ROCK = 'X'; // 돌
    private static final char CAVE = 'D'; // 비버의 굴
    private static final char CURRENT_POSITION = 'S'; // 고슴도치의 위치

    private static final Queue<int[]> currentPosition = new LinkedList<>(); // 현재 고슴도치 위치
    private static final Queue<int[]> water = new LinkedList<>(); // 현재 물의 위치

    private static boolean IS_POSSIBLE = false; // 비버의 굴에 들어갈 수 있는지

    private static final int[] dy = {-1, 1, 0, 0}; // 상하
    private static final int[] dx = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        forest = new char[R][C];

        // 숲 초기화 및 물, 고슴도치 위치 확인
        for (int i = 0; i < R; i++) {
            char[] values = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                char value = values[j];
                forest[i][j] = value;
                if (value == WATER) {
                    water.add(new int[]{i, j});
                } else if (value == CURRENT_POSITION) {
                    currentPosition.add(new int[]{i, j});
                }
            }
        }

        int count = 0;
        while (!currentPosition.isEmpty() && !IS_POSSIBLE) { // 고슴도치가 이동 가능한지, 동굴을 찾았는지
            count++;
            Water();
            Move();
        }

        if (IS_POSSIBLE) bw.write(count + "");
        else bw.write("KAKTUS");

        br.close();
        bw.flush();
        bw.close();

    }

    // 인접 칸 물 채우기
    private static void Water() {
        int size = water.size();
        for (int i = 0; i < size; i++) {

            int[] pos = water.poll();

            for (int j = 0; j < 4; j++) {
                int ny = pos[0] + dy[j];
                int nx = pos[1] + dx[j];

                if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if (forest[ny][nx] == EMPTY) {
                        forest[ny][nx] = WATER;
                        water.add(new int[]{ny, nx});
                    }
                }
            }

        }
    }

    // 고슴도치 이동
    private static void Move() {
        int size = currentPosition.size();
        for (int i = 0; i < size; i++) {

            int[] pos = currentPosition.poll();

            for (int j = 0; j < 4; j++) {
                int ny = pos[0] + dy[j];
                int nx = pos[1] + dx[j];

                if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if (forest[ny][nx] == CAVE) IS_POSSIBLE = true;
                    else if (forest[ny][nx] == EMPTY) {
                        forest[ny][nx] = CURRENT_POSITION;
                        currentPosition.add(new int[]{ny, nx});
                    }
                }
            }

        }
    }

}
