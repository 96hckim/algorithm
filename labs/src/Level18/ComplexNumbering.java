package Level18;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ComplexNumbering {

    private static int[][] map;
    private static boolean[][] isVisited;

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int count;
    private static ArrayList<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new int[n + 2][n + 2];
        isVisited = new boolean[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) {
                    if (!isVisited[i][j]) {
                        count = 0;
                        dfs(i, j);
                        resultList.add(count);
                    }
                }
            }
        }

        bw.write(resultList.size() + "\n");

        Collections.sort(resultList);
        for (int result : resultList) {
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void dfs(int i, int j) {

        isVisited[i][j] = true;
        count++;

        for (int k = 0; k < 4; k++) {
            int y = i + dy[k];
            int x = j + dx[k];

            if (map[y][x] == 1) {
                if (!isVisited[y][x]) {
                    dfs(y, x);
                }
            }
        }

    }

}
