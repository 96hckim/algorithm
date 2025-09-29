package src;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NumberCardCounter_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> cardMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            cardMap.put(num, cardMap.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st.nextToken());
            bw.write(cardMap.getOrDefault(query, 0) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
