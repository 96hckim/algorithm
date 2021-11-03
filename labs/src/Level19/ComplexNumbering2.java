package Level19;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ComplexNumbering2 {

    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    private static int houseCount = 0;
    private static ArrayList<Integer> complexList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new int[n + 2][n + 2];
        visited = new boolean[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            String[] value = br.readLine().split("");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(value[j - 1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    houseCount = 1;
                    bfs(i, j);
                    complexList.add(houseCount);
                }
            }
        }

        bw.write(complexList.size() + "\n");
        Collections.sort(complexList);
        for (int houseCount : complexList) bw.write(houseCount + "\n");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs(int i, int j) {

        visited[i][j] = true;
        ArrayList<int[]> needVisit = new ArrayList<>();
        needVisit.add(new int[]{i, j});

        while (!needVisit.isEmpty()) {

            int[] coordinate = needVisit.remove(0);

            for (int k = 0; k < 4; k++) {
                int y = coordinate[0] + dy[k];
                int x = coordinate[1] + dx[k];

                if (map[y][x] == 1 && !visited[y][x]) {
                    visited[y][x] = true;
                    needVisit.add(new int[]{y, x});
                    houseCount++;
                }
            }

        }

    }

}
