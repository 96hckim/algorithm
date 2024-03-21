package basic_part_2.brute_force_540;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Set_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        HashSet<String> S = new HashSet<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "add":
                    S.add(st.nextToken());
                    break;
                case "remove":
                    S.remove(st.nextToken());
                    break;
                case "check":
                    bw.write(S.contains(st.nextToken()) ? "1" : "0");
                    bw.newLine();
                    break;
                case "toggle":
                    String x = st.nextToken();
                    if (S.contains(x)) {
                        S.remove(x);
                    } else {
                        S.add(x);
                    }
                    break;
                case "all":
                    S = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"));
                    break;
                case "empty":
                    S.clear();
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
