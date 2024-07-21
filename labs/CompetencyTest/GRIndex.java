package CompetencyTest;

import java.io.*;
import java.util.StringTokenizer;

public class GRIndex {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int P; // 문제의 수
    private static int N; // 수강생의 수
    private static int K; // 기쁨을 위한 문제 수
    private static int[][] arr; // 수강생별 문제 배열
    private static int SPECIAL; // 최소 특강 횟수
    private static boolean IS_ALL_HAPPY; // 모두 만족했는지

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[P][N];
        SPECIAL = 0;
        IS_ALL_HAPPY = false;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                switch (st.nextToken()) {
                    case "S":
                        arr[i][j] = 1;
                        break;
                    case "A":
                        arr[i][j] = 2;
                        break;
                    case "B":
                        arr[i][j] = 3;
                        break;
                    case "C":
                        arr[i][j] = 4;
                        break;
                    case "D":
                        arr[i][j] = 5;
                        break;
                    case "F":
                        arr[i][j] = 6;
                        break;
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
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input();

            isAllHappy(arr);

            while (!IS_ALL_HAPPY) { // 모두가 만족할때까지
                SPECIAL++; // 특강 횟수 추가
                chooseQuestions(new int[SPECIAL], 0, 0);
            }

            bw.write("#" + t + " " + SPECIAL + "\n");
        }

        output();
    }

    // 모두 만족하는지 체크
    private static void isAllHappy(int[][] map) {
        int happy = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            int prev = 0;

            for (int j = 0; j < P; j++) {
                if (map[j][i] <= prev) count++;
                else count = 1;
                prev = map[j][i];

                if (K == count) {
                    happy++;
                    break;
                }
            }
        }

        if (happy == N) IS_ALL_HAPPY = true;
    }

    // 특강으로 선택할 문제 선별
    private static void chooseQuestions(int[] questions, int x, int from) {
        if (IS_ALL_HAPPY) return;

        if (x == questions.length) {
            chooseLectures(questions, new int[questions.length], 0, 5);
        } else {
            for (int i = from; i < P; i++) {
                questions[x] = i;
                chooseQuestions(questions, x + 1, i + 1);
            }
        }
    }

    // 특강 문제별 지수 선별
    private static void chooseLectures(int[] questions, int[] lectures, int x, int from) {
        if (IS_ALL_HAPPY) return;

        if (x == lectures.length) {
            int[][] map = copyArray();

            for (int i = 0; i < lectures.length; i++) {
                for (int j = 0; j < N; j++) {
                    map[questions[i]][j] = lectures[i];
                }
            }

            isAllHappy(map);
        } else {
            for (int i = from; i >= 1; i--) {
                lectures[x] = i;
                chooseLectures(questions, lectures, x + 1, i);
            }
        }
    }

    // 복사
    private static int[][] copyArray() {
        int[][] map = new int[P][N];

        for (int i = 0; i < P; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = arr[i][j];
            }
        }

        return map;
    }

}
