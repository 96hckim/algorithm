package CompetencyTest.practice;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CHEEZE {

    private static int N; // 치즈 판 세로
    private static int M; // 치즈 판 가로
    private static int[][] plate; // 치즈 판 배열

    private static int MELTING_TIME; // 치즈가 녹는 데 걸린 시간
    private static int REMAINING_PIECE; // 모두 녹기 한 시간 전 남아있는 치즈 조각 수
    private static int CURRENT_MELT_CHEESE; // 이번 시간에 녹을 치즈 수

    private static final int[] dy = {-1, 1, 0, 0}; // 상하
    private static final int[] dx = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        plate = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int value = Integer.parseInt(st.nextToken());
                plate[i][j] = value;
                if (value == 1) REMAINING_PIECE++;
            }
        }

        while (REMAINING_PIECE > 0) {
            MELTING_TIME++;
            CURRENT_MELT_CHEESE = meltingCheese();
            REMAINING_PIECE -= CURRENT_MELT_CHEESE;
        }

        bw.write(MELTING_TIME + "\n");
        bw.write(CURRENT_MELT_CHEESE + "");

        br.close();
        bw.flush();
        bw.close();

    }

    // 치즈를 녹이는 함수
    private static int meltingCheese() {

        int count = 0;
        boolean[][] visited = new boolean[N + 1][M + 1];
        Queue<int[]> needVisit = new LinkedList<>();
        needVisit.add(new int[]{1, 1});
        visited[1][1] = true;

        while (!needVisit.isEmpty()) {

            int[] pos = needVisit.poll();

            for (int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];

                if (ny > 0 && ny <= N && nx > 0 && nx <= M) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;

                        if (plate[ny][nx] == 1) {
                            count++;
                            plate[ny][nx] = 0;
                        } else {
                            needVisit.add(new int[]{ny, nx});
                        }
                    }
                }
            }

        }

        return count;

    }

}
