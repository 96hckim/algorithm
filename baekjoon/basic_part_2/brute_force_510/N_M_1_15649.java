package basic_part_2.brute_force_510;

import java.io.*;
import java.util.StringTokenizer;

public class N_M_1_15649 {
    static int N, M;
    static int[] permutation;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        permutation = new int[M];
        visited = new boolean[N + 1];

        generatePermutations(0);

        br.close();
        bw.flush();
        bw.close();
    }

    static void generatePermutations(int depth) throws IOException {
        if (depth == M) {
            // depth 가 M까지 도착하면 sb에 집어넣고 return
            for (int num : permutation) {
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true; // 방문한 노드는 true
                permutation[depth] = i;
                generatePermutations(depth + 1);
                visited[i] = false; // 탐색이 모두 끝나면 모두 false 로 변경
            }
        }
    }
}
