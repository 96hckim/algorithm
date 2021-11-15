package CompetencyTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Password implements Comparable<Password> {

    int order;
    int password;

    public Password(int order, int password) {
        this.order = order < 9 ? order : 18 - order;
        this.password = password;
    }

    @Override
    public int compareTo(Password o) {
        if (this.password != o.password) return this.password - o.password;
        else return this.order - o.password;
    }

    @Override
    public String toString() {
        return "{" +
                order +
                ", " +
                password +
                '}';
    }

}

public class DormPassword {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int K; // 테스트 케이스
    private static int ORDER; // 비밀번호 리스트 중 ORDER 번째 수가 진짜 비밀번호
    private static char[] numbers; // 비밀번호 수열
    private static ArrayList<Password> passwords; // 조합 가능한 비밀번호 리스트

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        ORDER = Integer.parseInt(st.nextToken());
        numbers = st.nextToken().toCharArray();
        passwords = new ArrayList<>(numbers.length);
    }

    // 출력
    private static void output() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

    // 메인
    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());

        for (int t = 1; t <= K; t++) {
            input();
            getPasswords();
            Password password = passwords.get(ORDER - 1);
            bw.write("#" + t + " " + password.order + " " + password.password + "\n");
        }

        output();
    }

    // 현재 수열에서 조합 가능한 모든 비밀번호를 오름차순으로 가져온다
    private static void getPasswords() {
        for (int i = 0; i < numbers.length; i++) {
            char a = numbers[i];
            char b = numbers[i + 1 >= numbers.length ? i + 1 - numbers.length : i + 1];
            char c = numbers[i + 2 >= numbers.length ? i + 2 - numbers.length : i + 2];

            passwords.add(new Password(i, convert32to10(a) * 32 * 32 + convert32to10(b) * 32 + convert32to10(c)));
        }
        Collections.sort(passwords);
    }

    // 32진수 -> 10진수
    private static int convert32to10(char n) {
        return n >= 'A' ? n - 'A' + 10 : n - '0';
    }

}
