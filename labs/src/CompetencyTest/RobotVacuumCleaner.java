package CompetencyTest;

import java.io.*;
import java.util.*;

public class RobotVacuumCleaner {

    private static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int N; // 방 가로, 세로 길이
    private static int[][] room; // 방 배열

    private static final HashMap<Integer, ArrayList<Pair>> warp = new HashMap<>(); // 워프 장치 좌표

    private static final int[] dy = {-1, 1, 0, 0}; // 상하
    private static final int[] dx = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        room = new int[N + 2][N + 2];

        boundary();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                room[i][j] = value;
                if (value >= 6) {
                    ArrayList<Pair> pair = warp.getOrDefault(value, new ArrayList<>());
                    pair.add(new Pair(i, j));
                    warp.put(value, pair);
                }
            }
        }

        for (int key : warp.keySet()) {
            ArrayList<Pair> list = warp.get(key);
            for (Pair pair : list) {
                System.out.println(pair.y + " " + pair.x);
            }
        }

        bw.write(getMax() + "");

        br.close();
        bw.flush();
        bw.close();

    }

    // 경계선 처리
    private static void boundary() {
        for (int i = 0; i < room.length; i++) {
            room[i][0] = room[i][room[0].length - 1] = -2;
        }

        for (int i = 0; i < room[0].length; i++) {
            room[0][i] = room[room.length - 1][i] = -2;
        }
    }

    private static int getMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (room[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int count = bfs(i, j, k);
                        if (max < count) max = count;
                    }
                }
            }
        }
        return max;
    }

    private static int bfs(int i, int j, int k) {

        int count = 0;
        Queue<int[]> needVisit = new LinkedList<>();
        needVisit.add(new int[]{i, j, k});

        while (!needVisit.isEmpty()) {

            int[] pos = needVisit.poll();
            int y = pos[0];
            int x = pos[1];
            int d = pos[2];

            int ny = y + dy[d];
            int nx = x + dx[d];
//            System.out.println(y + " "  + x + " " + count + " " + room[ny][nx] + " " + d);

            switch (room[ny][nx]) {
                case -2:
                case 5:
                    d = reverseDir(d);
                    ny = y;
                    nx = x;
                    break;
                case 1:
                    if (d == 3) {
                        d = 0;
                    } else if (d == 1) {
                        d = 2;
                    } else {
                        d = reverseDir(d);
                        ny = y;
                        nx = x;
                    }
                    break;
                case 2:
                    if (d == 1) {
                        d = 3;
                    } else if (d == 2) {
                        d = 0;
                    } else {
                        d = reverseDir(d);
                        ny = y;
                        nx = x;
                    }
                    break;
                case 3:
                    if (d == 0) {
                        d = 3;
                    } else if (d == 2) {
                        d = 1;
                    } else {
                        d = reverseDir(d);
                        ny = y;
                        nx = x;
                    }
                    break;
                case 4:
                    if (d == 3) {
                        d = 1;
                    } else if (d == 0) {
                        d = 2;
                    } else {
                        d = reverseDir(d);
                        ny = y;
                        nx = x;
                    }
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    ArrayList<Pair> pairs = warp.get(room[ny][nx]);
                    if (ny == pairs.get(0).y && nx == pairs.get(0).x) {
                        ny = pairs.get(1).y;
                        nx = pairs.get(1).x;
                    } else {
                        ny = pairs.get(0).y;
                        nx = pairs.get(0).x;
                    }
                    break;
            }

            if (!(ny == y && nx == x)) {
                count++;
            }

            if (room[ny][nx] != -2) {
                if (room[ny][nx] == -1 || (ny == i && nx == j && d == k)) {
                    break;
                } else {
                    needVisit.add(new int[]{ny, nx, d});
                }
            }

        }

        return count;

    }

    private static int reverseDir(int dir) {
        switch (dir) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 2;
        }
        return -1;
    }

}
