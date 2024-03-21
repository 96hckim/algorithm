package basic_part_2.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023 {
    static String result;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        result = "0";
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, 1);
            if ("1".equals(result)) {
                break;
            }
        }

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int i, int depth) {
        if (depth == 5) {
            result = "1";
            return;
        }

        visited[i] = true;
        for (int j : graph[i]) {
            if (!visited[j]) {
                dfs(j, depth + 1);
                if ("1".equals(result)) {
                    return; // 결과가 1이면 탐색 중단
                }
            }
        }
        visited[i] = false;
    }
}
