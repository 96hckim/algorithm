package Special.diffuser.concept;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CombinationAlgorithm2 {

    private static class Perfume {

        int y, x;

        public Perfume(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int M;
    private static int K;
    private static int T;

    private static int[][] map;
    private static ArrayList<Perfume> perfumes;
    private static int COUNT;
    private static boolean IS_CLEAR;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        perfumes = new ArrayList<>();
        COUNT = 0;
        IS_CLEAR = false;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) perfumes.add(new Perfume(i, j));
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
        input();
        permutation(new Perfume[K], 0, 0);
        output();
    }

    private static void permutation(Perfume[] selected, int x, int from) throws IOException {
        if (IS_CLEAR) return;

        if (x == K) {
            if (T == ++COUNT) print(selected);
        } else {
            for (int i = from; i < perfumes.size(); i++) {
                selected[x] = perfumes.get(i);
                permutation(selected, x + 1, i + 1);
            }
        }
    }

    private static void print(Perfume[] selected) throws IOException {
        for (Perfume perfume : selected) {
            bw.write(perfume.y + " " + perfume.x + "\n");
        }
    }

}
