package Special.Slime.inquiryandspread;

import java.io.*;
import java.util.*;

public class SlimeD {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int M;
    private static int X;
    private static int Y;
    private static int[][] field;

    private static boolean[][] visited;
    private static ArrayList<Integer> result;

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        visited = new boolean[N][M];
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }

    // 출력
    private static void output() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

    // 메인
    public static void main(String[] args) throws IOException {
        input();
        inquiry();
        result.sort(Collections.reverseOrder());
        if (result.isEmpty()) bw.write(-1 + "");
        else for (int sum : result) bw.write(sum + "\n");
        output();
    }

    private static void inquiry() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    spread(i, j);
                }
            }
        }
    }

    private static void spread(int i, int j) {

        Queue<int[]> needCombine = new LinkedList<>();
        needCombine.add(new int[]{i, j});
        visited[i][j] = true;

        int sum = field[i][j];
        int count = 1;

        while (!needCombine.isEmpty()) {

            int[] pos = needCombine.poll();
            int y = pos[0];
            int x = pos[1];

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (!visited[ny][nx]) {

                        int sub = Math.abs(field[y][x] - field[ny][nx]);

                        if (sub >= X && sub <= Y) {
                            sum += field[ny][nx];
                            count++;
                            visited[ny][nx] = true;
                            needCombine.add(new int[]{ny, nx});
                        }
                    }
                }
            }

        }

        if (count > 1) result.add(sum / count);

    }

}
