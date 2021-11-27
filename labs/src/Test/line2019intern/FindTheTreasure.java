package Test.line2019intern;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class FindTheTreasure {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int M;
    private static int A;
    private static int B;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
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
        if (check()) bw.write("fail");
        else {
            int TIME = A + B;
            BigInteger ab = factorial(BigInteger.valueOf(A + B));
            BigInteger a = factorial(BigInteger.valueOf(A));
            BigInteger b = factorial(BigInteger.valueOf(B));
            BigInteger COUNT = ab.divide(a.multiply(b));
            bw.write(TIME + "\n");
            bw.write(COUNT + "\n");
        }
        output();
    }

    private static boolean check() {
        return (A == 0 && B == 0) || A >= N || B >= M;
    }

    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }

}
