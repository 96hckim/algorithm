package Special.migratorybird.partialconcept;

import java.io.*;
import java.util.StringTokenizer;

public class GroupMove {

    private static class Person {

        int y, x, d;

        public Person(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

        @Override
        public String toString() {
            return "{" +
                    "y=" + y +
                    ", x=" + x +
                    ", d=" + d +
                    '}';
        }

    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int M;
    private static int k;
    private static int t;

    private static Person[][][] map;
    private static int[][] size;
    private static Person[] people;

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] rd = {1, 0, 3, 2};

    // 입력
    private static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new Person[N + 1][M + 1][k];
        size = new int[N + 1][M + 1];
        people = new Person[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            people[i] = new Person(y, x, d);
            map[y][x][size[y][x]++] = people[i];
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
        for (int i = 0; i < t; i++) move();
        for (Person p : people) bw.write(p.y + " " + p.x + "\n");
        output();
    }

    private static void move() {
        for (Person p : people) {

            int y = p.y;
            int x = p.x;

            int ny = y + dy[p.d];
            int nx = x + dx[p.d];

            if (ny < 1 || ny > N || nx < 1 || nx > M) {
                p.d = rd[p.d];
                ny = y + dy[p.d];
                nx = x + dx[p.d];
            }

            for (int i = 0; i < size[y][x]; i++) {
                map[y][x][i].y = ny;
                map[y][x][i].x = nx;
                map[ny][nx][size[ny][nx]++] = map[y][x][i];
                map[y][x][i] = null;
            }
            size[y][x] = 0;

        }
    }

}

