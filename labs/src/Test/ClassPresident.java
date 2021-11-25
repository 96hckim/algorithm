package Test;

import java.io.*;
import java.util.StringTokenizer;

public class ClassPresident {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int[][] chart;
    private static int[] count;

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        chart = new int[N][5];
        count = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                chart[i][j] = Integer.parseInt(st.nextToken());
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
        permutation(new int[2], 0, 0);
        bw.write(getResult() + "");
        output();
    }

    private static void permutation(int[] students, int x, int from) {
        if (x == 2) {
            check(students);
        } else {
            for (int i = from; i < N; i++) {
                students[x] = i;
                permutation(students, x + 1, i + 1);
            }
        }
    }

    private static void check(int[] students) {
        int s1 = students[0];
        int s2 = students[1];

        if (chart[s1][0] == chart[s2][0] ||
                chart[s1][1] == chart[s2][1] ||
                chart[s1][2] == chart[s2][2] ||
                chart[s1][3] == chart[s2][3] ||
                chart[s1][4] == chart[s2][4]) {
            count[s1]++;
            count[s2]++;
        }
    }

    private static int getResult() {
        int max = 0;
        int student = 1;

        for (int s = 0; s < N; s++) {

            int sum = count[s];

            if (max < sum) {
                max = sum;
                student = s + 1;
            }

        }

        return student;
    }

}
