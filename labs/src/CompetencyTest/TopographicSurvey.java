package CompetencyTest;

import java.io.*;
import java.util.StringTokenizer;

public class TopographicSurvey {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N; // 지형의 크기
    private static int K; // 구간 길이
    private static int[][] map; // 지형
    private static int LINE; // 오르막이나 내리막이 있는 줄 수

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        LINE = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
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
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input();
            lineCheck();
            bw.write("#" + t + " " + LINE + "\n");
        }

        output();
    }

    // 가로, 세로 줄마다 검사하여 오르막, 내리막 있는지 검사
    private static void lineCheck() {
        int[] heights = new int[K]; // 검사할 지형 높이 저장

        for (int l = 0; l < 2; l++) { // 0:가로, 1:세로
            for (int i = 0; i < N; i++) {
                boolean isHill = false; // 해당 줄이 오르막인지 내리막인지

                for (int j = 0; j < N - K + 1; j++) {

                    // 가로, 세로 별 검사할 지형 높이 저장
                    if (l == 0) { // 가로
                        for (int k = 0; k < K; k++) {
                            heights[k] = map[i][j + k];
                        }
                    } else { // 세로
                        for (int k = 0; k < K; k++) {
                            heights[k] = map[j + k][i];
                        }
                    }

                    if (heights[0] - heights[1] >= 2) { // 내리막
                        for (int k = 0; k < K - 1; k++) {
                            if (heights[k] - heights[k + 1] >= 2) isHill = true;
                            else {
                                isHill = false;
                                break;
                            }
                        }
                    } else if (heights[0] - heights[1] <= -2) { // 오르막
                        for (int k = 0; k < K - 1; k++) {
                            if (heights[k] - heights[k + 1] <= -2) isHill = true;
                            else {
                                isHill = false;
                                break;
                            }
                        }
                    }

                    if (isHill) { // 오르막 or 내리막이면 해당 줄 추가
                        LINE++;
                        break;
                    }
                }
            }
        }
    }

}
