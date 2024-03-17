package basic_part_2.brute_force_500;

import java.io.*;

public class CandyGame_3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            System.arraycopy(input, 0, grid[i], 0, N);
        }

        int maxCandies = findMaxCandies(grid);
        bw.write(maxCandies + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static int findMaxCandies(char[][] grid) {
        int max = Integer.MIN_VALUE;

        // 가로로 이웃한 사탕 교환
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                swap(grid, i, j, i, j + 1);
                max = Math.max(max, findMaxConsecutive(grid));
                swap(grid, i, j, i, j + 1); // 원래대로 되돌리기
            }
        }

        // 세로로 이웃한 사탕 교환
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length - 1; j++) {
                swap(grid, j, i, j + 1, i);
                max = Math.max(max, findMaxConsecutive(grid));
                swap(grid, j, i, j + 1, i); // 원래대로 되돌리기
            }
        }

        return max;
    }

    static void swap(char[][] grid, int x1, int y1, int x2, int y2) {
        char temp = grid[x1][y1];
        grid[x1][y1] = grid[x2][y2];
        grid[x2][y2] = temp;
    }

    static int findMaxConsecutive(char[][] grid) {
        int max = 1;

        // 가로로 연속된 사탕 개수 확인
        for (int i = 0; i < grid.length; i++) {
            int count = 1;
            for (int j = 0; j < grid[0].length - 1; j++) {
                if (grid[i][j] == grid[i][j + 1]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        // 세로로 연속된 사탕 개수 확인
        for (int i = 0; i < grid[0].length; i++) {
            int count = 1;
            for (int j = 0; j < grid.length - 1; j++) {
                if (grid[j][i] == grid[j + 1][i]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
