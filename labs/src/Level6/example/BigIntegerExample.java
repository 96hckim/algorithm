package Level6.example;

import java.io.*;
import java.math.BigInteger;

/**
 * add : 덧셈
 * subtract : 뺄셈
 * multiply : 곱셈
 * divide : 나눗셈
 * remainder : 나머지
 */
public class BigIntegerExample {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        String result = a.add(b) + "";

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();

    }

}
