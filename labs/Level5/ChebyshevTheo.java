package Level5;

import java.io.*;

public class ChebyshevTheo {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            int primeCount = 0;

            if (n == 0) break;

            for (int i = n + 1; i <= 2 * n; i++) {
                boolean isPrime = true;

                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) primeCount++;
            }

            bw.write(primeCount + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
