package src;

import java.io.*;
import java.util.*;

public class UnheardUnseen_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> unheard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                result.add(name);
            }
        }

        bw.write(result.size() + "\n");
        for (String name : result) {
            bw.write(name + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
