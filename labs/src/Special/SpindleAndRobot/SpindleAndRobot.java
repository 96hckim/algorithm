package Special.SpindleAndRobot;

import java.io.*;
import java.util.StringTokenizer;

public class SpindleAndRobot {

    /**
     * 결과 출력
     * #x, 로봇이 얻은 점수, 로봇의 최종 위치(x, y)
     * ex) #1 54 2 5
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());

        // 케이스별 실행
        for (int t = 1; t <= testCase; t++) {
            int n;                  // 가로
            int m;                  // 세로
            int x;                  // x 좌표
            int y;                  // y 좌표
            int[][] mapArray;       // 맵
            int k;                  // 회전판 칸의 개수
            int[] spindleArray;     // 회전판의 값
            int l;                  // 로봇의 움직이는 횟수
            int moveDirection = 0;  // 이동할 방향
            int spinDirection;      // 회전 방향
            int spinCount;          // 회전시키는 칸 수
            int spindleIndex = 0;   // 회전판 위치
            int[] dx = {1, -1, 0, 0};   // 좌, 우
            int[] dy = {0, 0, 1, -1};   // 상, 하
            int score = 0;

            // 맵 크기 및 현재 위치 저장
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // 맵 크기 지정
            mapArray = new int[m + 2][n + 2];

            // 경계 밖 장애물 설치 -1 (좌, 우)
            for (int i = 0; i < mapArray.length; i++) {
                mapArray[i][0] = mapArray[i][mapArray[0].length - 1] = -1;
            }

            // 경계 밖 장애물 설치 -1 (상, 하)
            for (int i = 0; i < mapArray[0].length; i++) {
                mapArray[0][i] = mapArray[mapArray.length - 1][i] = -1;
            }

            // 맵 저장
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    mapArray[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 회전판 저장
            k = Integer.parseInt(br.readLine());
            spindleArray = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < spindleArray.length; i++) {
                spindleArray[i] = Integer.parseInt(st.nextToken());
            }

            // 로봇 움직일 횟수 저장
            l = Integer.parseInt(br.readLine());
            // 로봇 이동
            for (int i = 0; i < l; i++) {
                st = new StringTokenizer(br.readLine());

                // 나아갈 방향 저장
                switch (st.nextToken()) {
                    case "E":
                        moveDirection = 0;
                        break;
                    case "W":
                        moveDirection = 1;
                        break;
                    case "S":
                        moveDirection = 2;
                        break;
                    case "N":
                        moveDirection = 3;
                        break;
                }

                // 회전판 회전 방향 및 회전 횟수 저장
                spinDirection = Integer.parseInt(st.nextToken());
                spinCount = Integer.parseInt(st.nextToken());

                // 회전 주기
                spinCount %= k;

                // 회전판의 회전 방향 (1: 역방향, 2: 정방향)
                if (spinDirection == 1) {
                    if (spindleIndex - spinCount < 0) {
                        spindleIndex = k - (spinCount - spindleIndex);
                    } else {
                        spindleIndex = spindleIndex - spinCount;
                    }
                } else {
                    if (spindleIndex + spinCount >= k) {
                        spindleIndex = spindleIndex + (spinCount - k);
                    } else {
                        spindleIndex = spindleIndex + spinCount;
                    }
                }

                // 움직일 거리 저장
                int moveCount = spindleArray[spindleIndex];

                for (int j = 0; j < moveCount; j++) {
                    // 점수 저장
                    score += mapArray[y][x];
                    mapArray[y][x] = 0;

                    // 다음 좌표
                    int ny = y + dy[moveDirection];
                    int nx = x + dx[moveDirection];

                    // 다음 이동 장소가 장애물, 경계선일 시 멈춤
                    if (mapArray[ny][nx] == -1) {
                        break;
                    }

                    x = nx;
                    y = ny;
                    score += mapArray[y][x];
                    mapArray[y][x] = 0;
                }

            }

            // 출력
            bw.write("#" + t + " " + score + " " + x + " " + y + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
