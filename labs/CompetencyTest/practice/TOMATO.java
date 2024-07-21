package CompetencyTest.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TOMATO {

    private static int M; // 상자의 가로 칸의 수
    private static int N; // 상자의 세로 칸의 수
    private static int H; // 상자의 수
    private static int[][][] box; // 상자의 토마토 상태 배열

    private static final ArrayList<int[]> needVisit = new ArrayList<>(); // 다음 익을 토마토 배열

    private static final int[] dy = {-1, 1, 0, 0, 0, 0}; // 앞뒤
    private static final int[] dx = {0, 0, -1, 1, 0, 0}; // 좌우
    private static final int[] dh = {0, 0, 0, 0, -1, 1}; // 상하

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];

        // 토마토 상자 초기화
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int value = Integer.parseInt(st.nextToken());
                    box[i][j][k] = value;
                    if (value == 1) needVisit.add(new int[]{i, j, k});
                }
            }
        }

        // 모든 토마토 익히데 걸리는 일 수 세기
        int count = -1;
        while (!needVisit.isEmpty()) {
            count++;
            doRipeTomato((ArrayList<int[]>) needVisit.clone());
        }

        if (check()) bw.write(count + "");
        else bw.write(-1 + "");

        br.close();
        bw.flush();
        bw.close();

    }

    // 덜 익은 토마토가 있는지 검사
    private static boolean check() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }

    // 안 익은 토마토 익히기
    private static void doRipeTomato(ArrayList<int[]> ripeList) {

        needVisit.clear();

        while (!ripeList.isEmpty()) {

            int[] pos = ripeList.remove(0);
            int h = pos[0];
            int y = pos[1];
            int x = pos[2];

            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nh >= 0 && nh < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (box[nh][ny][nx] == 0) {
                        box[nh][ny][nx] = 1;
                        needVisit.add(new int[]{nh, ny, nx});
                    }
                }
            }

        }

    }

}
