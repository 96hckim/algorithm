package Special.migratorybird.partialconcept;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EasyMoveAlgorithm2 {

    private static class Person {

        int y, x, d, f;

        public Person(int y, int x, int d, int f) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.f = f;
        }

    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int M;
    private static int k;
    private static int t;

    private static Queue<Person> people;

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        people = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            people.add(new Person(y, x, d, f));
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
        move();
        output();
    }

    private static void move() throws IOException {
        while (!people.isEmpty()) {

            Person p = people.poll();

            int ny = p.y + dy[p.d] * p.f * t;
            int nx = p.x + dx[p.d] * p.f * t;

            if (ny < 1) bw.write(1 + " " + p.x);
            else if (ny > N) bw.write(N + " " + p.x);
            else if (nx < 1) bw.write(p.y + " " + 1);
            else if (nx > M) bw.write(p.y + " " + M);
            else bw.write(ny + " " + nx);
            bw.newLine();

        }
    }

}
