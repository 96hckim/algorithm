package CompetencyTest;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LikeRadar {

    private static int N; // 지도의 세로 크기
    private static int M; // 지도의 가로 크기
    private static int K; // 지급 받은 리봇의 갯수

    private static int[][] map; // 지도
    private static int max; // 확인할 수 있는 최대한 많은 인원의 프로필 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {

            // 초기화
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가장 많이 확인할 수 있는 장소 찾기
            search();

            // 확인 가능한 최대 프로필 수 출력
            bw.write("#" + t + " " + max + "\n");

        }

        br.close();
        bw.flush();
        bw.close();

    }

    // 최댓값 찾기
    private static void search() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    int count = radar(i, j);
                    if (max < count) max = count;
                }
            }
        }
    }

    // 현재 위치에서 레이더로 범위 탐색하여 최대한 많은 수의 프로필 수 GET
    private static int radar(int i, int j) {
        ArrayList<Integer> likePeoples = new ArrayList<>();
        int range = 1;
        int needRibbon = 0;
        int likePeople = 0;
        int sum = 0;

        while (needRibbon <= K) {
            sum += likePeople;

            int startY = Math.max(i - range, 0);
            int startX = Math.max(j - range, 0);
            int endY = Math.min(i + range, N - 1);
            int endX = Math.min(j + range, M - 1);

            likePeople = getLikePeople(i, j, startY, startX, endY, endX, range);
            likePeoples.add(0, likePeople);

            needRibbon = getRibbon(likePeoples, range);
            range++;
        }

        return sum;
    }

    // 주어진 범위 내 호감을 가진 사람의 수
    private static int getLikePeople(int y, int x, int startY, int startX, int endY, int endX, int range) {
        int count = 0;

        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if (range == Math.abs(y - i) + Math.abs(x - j) && map[i][j] == 1) count++;
            }
        }

        return count;
    }

    // 해당 범위의 사람들의 수에 따른 필요한 리봇 갯수
    private static int getRibbon(ArrayList<Integer> likePeoples, int range) {
        int ribbon = 0;

        for (int i = range; i >= 1; i--) {
            ribbon += i * likePeoples.get(i - 1);
        }

        return ribbon;
    }

}
