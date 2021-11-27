package Special.slime;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Slime {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N; // 들판의 세로 길이
    private static int M; // 들판의 가로 길이
    private static int X; // 슬라임의 질량의 차 X 이상
    private static int Y; // 슬라임의 질량의 차 Y 잏라
    private static int[][] field; // 들판 배열

    private static boolean[][] combined; // 이미 합친 곳인지
    private static boolean IS_COMBINED; // 합체가 일어났는지
    private static int COMBINATION_COUNT; // 몇 번 합쳤는지 카운트

    private static final int[] dy = {-1, 1, 0, 0}; // 상하 이동
    private static final int[] dx = {0, 0, -1, 1}; // 좌우 이동

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        IS_COMBINED = true;

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

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            input();
            COMBINATION_COUNT = -1; // 초회 합침 여부 상관없이 올라가므로 -1
            checkCombination();
            bw.write("#" + t + " " + COMBINATION_COUNT + "\n");
        }

        output();

    }

    // 합쳤는지 확인
    private static void checkCombination() {
        while (IS_COMBINED) {

            COMBINATION_COUNT++;

            // 합침 확인 변수 초기화
            IS_COMBINED = false;
            combined = new boolean[N][M];

            // 모든 좌표 돌면서 Combination Check
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!combined[i][j]) {
                        combination(i, j);
                    }
                }
            }

        }
    }

    // 합체
    private static void combination(int i, int j) {

        // 합쳐야 할 좌표 저장
        ArrayList<int[]> combinationPositions = new ArrayList<>();
        Queue<int[]> needCombine = new LinkedList<>();

        // 초기값 저장
        int[] position = {i, j};
        combinationPositions.add(position);
        needCombine.add(position);
        combined[i][j] = true;

        // 슬라임 질량 총합과 슬라임의 수
        int sum = field[i][j];
        int count = 1;

        while (!needCombine.isEmpty()) {

            // 현재 좌표
            int[] currentPosition = needCombine.poll();
            int y = currentPosition[0];
            int x = currentPosition[1];

            // 상하좌우 슬라임 합칠 수 있는지 체크
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                // 들판 범위 내
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (!combined[ny][nx]) {

                        // 슬라임 질량의 차
                        int sub = Math.abs(field[y][x] - field[ny][nx]);

                        // 슬라임 질량의 차 합체 범위 내
                        if (sub >= X && sub <= Y) {
                            combined[ny][nx] = true;

                            sum += field[ny][nx];
                            count++;

                            position = new int[]{ny, nx};
                            combinationPositions.add(position);
                            needCombine.add(position);
                        }

                    }
                }
            }

        }

        // 합체가 일어났는지 체크
        if (!IS_COMBINED) IS_COMBINED = combinationPositions.size() > 1;

        // 합친 슬라임 분리
        separation(combinationPositions, sum / count);

    }

    // 분리
    private static void separation(ArrayList<int[]> combinationPositions, int average) {
        // 합친 슬라임들 평균 질량으로 분리
        for (int[] position : combinationPositions) field[position[0]][position[1]] = average;
    }

}
