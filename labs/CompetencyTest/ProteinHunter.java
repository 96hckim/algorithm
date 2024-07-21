package CompetencyTest;

import java.io.*;
import java.util.StringTokenizer;

public class ProteinHunter {

    private static int N; // 지도 크기 N * N
    private static int[][] map; // 지도
    private static int max; // 가장 많이 얻을 수 있는 단백질 함량의 합

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            max = Integer.MIN_VALUE;

            // 지도 초기화
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 최댓값 찾기
            search();

            // 결과 출력
            bw.write("#" + t + " " + max + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    // 십자모양 탐색하여 최댓값 구하는 함수
    private static void search() {
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                int curMax = getMax(i, j);
                if (max < curMax) max = curMax;
            }
        }
    }

    // 현재 좌표에서 가져올 수 있는 최대의 담백질 함량
    private static int getMax(int i, int j) {
        boolean[] visited = new boolean[101]; // 같은 식품인지 체크
        int result = 0; // 결과값

        for (int k = 0; k < N; k++) { // 세로
            if (!visited[map[i][k]]) {
                visited[map[i][k]] = true;
                result += map[i][k];
            }
        }

        for (int k = 0; k < N; k++) { // 가로
            if (!visited[map[k][j]]) {
                visited[map[k][j]] = true;
                result += map[k][j];
            }
        }

        return result;
    }

}
