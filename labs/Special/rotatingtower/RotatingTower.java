package Special.rotatingtower;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RotatingTower {

    private static int n; // 회전판의 개수
    private static int m; // 회전판에 쓰여진 숫자 개수
    private static int k; // 회전 횟수
    private static int[][] towerArray; // 회전탑 배열 towerArray[n][m]
    private static int a; // 회전시킬 층의 번호 (배수)
    private static int d; // 회전 방향 (0:시계 방향, 1:반시계 방향)
    private static int c; // 회전시킬 칸 수
    private static boolean isDeleteSomething; // 회전시킬 칸 수
    private static int count; // 타워에 존재하는 수의 갯수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            // 회전탑 배열 초기화
            towerArray = new int[n + 2][m + 2];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    towerArray[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 상하 경계선 생성
            for (int i = 1; i < towerArray[0].length - 1; i++) {
                towerArray[0][i] = towerArray[towerArray.length - 1][i] = -1;
            }

            // 타워 회전
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                push(); // 해당 층 회전
                inquiry(); // 같은 수 조회

                // 어떠한 층에서도 지워지는 숫자가 없을 경우
                if (!isDeleteSomething) {
                    upOrDownThanAverage(average());
                }
            }

            // 모든 수의 합계 출력
            bw.write("#" + t + " " + sum() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    // 회전
    private static void push() {
        for (int i = a; i <= n; i += a) {

            if (d == 0) { // 시계 방향

                for (int j = 0; j < c; j++) {
                    int temp = towerArray[i][m];

                    for (int k = m - 1; k >= 1; k--) {
                        towerArray[i][k + 1] = towerArray[i][k];
                    }

                    towerArray[i][1] = temp;
                }

            } else { // 반시계 방향

                for (int j = 0; j < c; j++) {
                    int temp = towerArray[i][1];

                    for (int k = 2; k <= m; k++) {
                        towerArray[i][k - 1] = towerArray[i][k];
                    }

                    towerArray[i][m] = temp;
                }

            }

        }
    }

    // 상하좌우 같은 수가 있는지 조회
    private static void inquiry() {
        isDeleteSomething = false;
        ArrayList<String> deletePositions = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int top = i - 1;
                int bot = i + 1;
                int left = j - 1;
                int right = j + 1;

                if (left == 0) left = m;
                else if (right == m + 1) right = 1;

                if (towerArray[i][j] == towerArray[top][j] ||
                        towerArray[i][j] == towerArray[bot][j] ||
                        towerArray[i][j] == towerArray[i][left] ||
                        towerArray[i][j] == towerArray[i][right]) {
                    if (towerArray[i][j] != 0) {
                        isDeleteSomething = true;
                        deletePositions.add(i + "/" + j);
                    }
                }
            }
        }

        delete(deletePositions);
    }

    // 같은 수 삭제
    private static void delete(ArrayList<String> deletePositions) {
        for (String deletePosition : deletePositions) {
            String[] position = deletePosition.split("/");
            int indexI = Integer.parseInt(position[0]);
            int indexJ = Integer.parseInt(position[1]);

            towerArray[indexI][indexJ] = 0;
        }
    }

    // 모든 층의 수의 합 구하기
    private static int sum() {
        int result = 0;
        count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (towerArray[i][j] != 0) {
                    result += towerArray[i][j];
                    count++;
                }
            }
        }

        return result;
    }

    // 모든 층의 수의 평균
    private static int average() {
        return sum() / count;
    }

    // 평균보다 크면 -1 작으면 +1
    private static void upOrDownThanAverage(int average) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (towerArray[i][j] != 0) {
                    if (towerArray[i][j] > average) towerArray[i][j]--;
                    else if (towerArray[i][j] < average) towerArray[i][j]++;
                }
            }
        }
    }

}
