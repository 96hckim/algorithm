package CompetencyTest;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Mushroom {

    int y, x, max, height;

    public Mushroom(int y, int x, int max, int height) {
        this.y = y;
        this.x = x;
        this.max = max;
        this.height = height;
    }

}

public class MushroomCultivation {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N; // 버섯 격자판 세로
    private static int M; // 버섯 격자판 가로
    private static Mushroom[][] grid; // 버섯 격자판 배열
    private static Queue<int[]> needGrowth; // 성장이 필요한 버섯들
    private static int[] seedCount; // 격자판의 종자별 갯수
    private static StringBuilder result; // 종자별 갯수를 담은 결과 변수

    private static final int[] dy = {-1, 1, 0, 0}; // y축 이동
    private static final int[] dx = {0, 0, -1, 1}; // x축 이동

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new Mushroom[N][M];
        needGrowth = new LinkedList<>();
        seedCount = new int[11];
        result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (arr[j] == '0') grid[i][j] = null;
                else {
                    grid[i][j] = new Mushroom(i, j, arr[j] - ('A' - 1), 1);
                    needGrowth.add(new int[]{i, j});
                }
            }
        }
    }

    // 출력
    private static void output() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

    // 메인
    public static void main(String[] args) throws IOException {

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input();
            while (!needGrowth.isEmpty()) dayChange(); // 성장이 필요한 버섯이 없을 때 까지
            getResult();
            bw.write("#" + t + " " + result + "\n"); // 격자판의 종자별 갯수 출력
        }

        output();

    }

    private static void dayChange() {

        // 포자를 뿌린 위치
        int[][] spores = new int[N][M];
        ArrayList<int[]> positions = new ArrayList<>();

        int size = needGrowth.size();
        for (int s = 0; s < size; s++) {

            int[] pos = needGrowth.poll();
            Mushroom m = grid[pos[0]][pos[1]];

            if (m.max == m.height) { // 성장이 끝난 버섯
                seedCount[m.max]++; // 해당 종자 카운트 +1

                for (int i = 0; i < 4; i++) { // 상하좌우로 퍼진다
                    int ny = m.y + dy[i];
                    int nx = m.x + dx[i];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                        if (grid[ny][nx] == null) { // 버섯이 없다면 포자를 뿌린다
                            if (spores[ny][nx] < m.max) { // 최대 키가 큰 버섯이 자란다
                                positions.add(new int[]{ny, nx});
                                spores[ny][nx] = m.max;
                            }
                        }
                    }
                }
            } else { // 성장이 아직 덜된 버섯은 키 +1
                grid[m.y][m.x].height++;
                needGrowth.add(new int[]{m.y, m.x});
            }

        }

        for (int[] pos : positions) { // 뿌려진 종자들을 버섯으로
            int y = pos[0];
            int x = pos[1];
            grid[y][x] = new Mushroom(y, x, spores[y][x], 1);
            needGrowth.add(pos);
        }

    }

    // 격자판의 종자별 갯수를 결과로 담는다
    private static void getResult() {
        for (int i = 1; i <= 10; i++) result.append(seedCount[i]).append(" ");
    }

}
