package Test.line2019intern;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SeatAssignment {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;

    private static ArrayList<Integer> students;
    private static ArrayList<Integer> empty;

    private static int MAX;

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        students = new ArrayList<>();
        empty = new ArrayList<>();
        MAX = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value == 1) students.add(i);
            else empty.add(i);
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
        recursive(new int[1], 0);
        bw.write(MAX + "");
        output();
    }

    private static void recursive(int[] selected, int x) {
        if (x == 1) {
            int distance = binarySearch(selected[0]);
            if (MAX < distance) MAX = distance;
        } else {
            for (int seat : empty) {
                selected[x] = seat;
                recursive(selected, x + 1);
            }
        }
    }

    private static int binarySearch(int seat) {
        int start = 0;
        int end = students.size();

        while (start + 1 < end) {

            int midIndex = (start + end) / 2;
            int midValue = students.get(midIndex);

            if (seat >= midValue) {
                start = midIndex;
            } else {
                end = midIndex;
            }

        }

        if (end == students.size()) return Math.abs(seat - students.get(start));

        return Math.min(Math.abs(seat - students.get(start)), Math.abs(seat - students.get(end)));
    }

}
