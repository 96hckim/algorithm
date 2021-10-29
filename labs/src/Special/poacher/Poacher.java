package Special.poacher;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 멧돼지
class Boar {

    private int y; // r(세로)
    private int x; // c(가로)
    private int d; // 멧돼지가 달리고 있는 방향 (1:상 2:하 3:좌 4:우)
    private int f; // 달리는 속력
    private int w; // 멧돼지의 무게

    public Boar(int y, int x, int d, int f, int w) {
        this.y = y;
        this.x = x;
        this.d = d;
        this.f = f;
        this.w = w;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    @Override
    public String toString() {
        return "Boar{" +
                "y=" + y +
                ", x=" + x +
                ", d=" + d +
                ", f=" + f +
                ", w=" + w +
                '}';
    }

}

public class Poacher {

    private static int r;                       // 세로
    private static int c;                       // 가로
    private static int m;                       // 멧돼지 마릿수
    private static Boar[][] poacherArray;       // 밀렵꾼이 있는 장소
    private static ArrayList<Boar> boars;       // 멧돼지 목록
    private static int[] dy = {-1, 1, 0, 0};    // y 방향
    private static int[] dx = {0, 0, -1, 1};    // x 방향
    private static int[] nd = {1, 0, 3, 2};     // 다음 방향
    private static ArrayList<Boar> eatenBoars;  // 먹힌 멧돼지들
    private static ArrayList<Boar> huntedBoars; // 사냥당한 멧돼지들

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            boars = new ArrayList<>();
            huntedBoars = new ArrayList<>();

            // 멧돼지 저장
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;
                int f = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                if (d < 2) f %= 2 * r - 2;
                else f %= 2 * c - 2;

                boars.add(new Boar(y, x, d, f, w));
            }

            // 주어진 격자판 열 갯수만큼 멧돼지 이동 및 포획
            for (int i = 1; i <= c; i++) {

                // 초기화
                poacherArray = new Boar[r + 2][c + 2];
                eatenBoars = new ArrayList<>();

                // 멧돼지 이동 및 중복 체크
                for (Boar boar : boars) {

                    if (boar.getD() < 2) boar.setY(moving(boar.getY(), boar.getF() * dy[boar.getD()], r, boar));
                    else boar.setX(moving(boar.getX(), boar.getF() * dx[boar.getD()], c, boar));

                    duplicateCheck(boar);

                }

                // 먹힌 멧돼지들 삭제
                for (Boar boar : eatenBoars) {
                    boars.remove(boar);
                }

                // 포획
                hunting(i);

            }

            // 포획한 멧돼지 총 무게
            int boarsWeightSum = getBoarsWeightSum();

            // 출력
            bw.write("#" + t + " " + boarsWeightSum + "\n");

        }

        br.close();
        bw.flush();
        bw.close();

    }

    // 멧돼지 이동
    private static int moving(int position, int distance, int max, Boar boar) {

        while (position + distance < 1 || position + distance > max) {

            boar.setD(nd[boar.getD()]);

            if (position + distance < 1) {
                distance += position - 1;
                position = 1;
            } else if (position + distance > max) {
                distance -= max - position;
                position = max;
            }

            distance = -distance;

        }

        return position + distance;

    }

    // 중복 체크 (무게 높은 멧돼지가 낮은 멧돼지 잡아먹음)
    private static void duplicateCheck(Boar boar) {

        if (poacherArray[boar.getY()][boar.getX()] == null) poacherArray[boar.getY()][boar.getX()] = boar;
        else {
            if (poacherArray[boar.getY()][boar.getX()].getW() < boar.getW()) {
                eatenBoars.add(poacherArray[boar.getY()][boar.getX()]);
                poacherArray[boar.getY()][boar.getX()] = boar;
            }
        }

    }

    // 멧돼지 포획
    private static void hunting(int position) {
        for (int i = r; i >= 1; i--) {
            if (poacherArray[i][position] != null) {
                huntedBoars.add(poacherArray[i][position]);
                boars.remove(poacherArray[i][position]);
                poacherArray[i][position] = null;
                break;
            }
        }
    }

    // 포획한 멧돼지 총 무게
    private static int getBoarsWeightSum() {
        int sum = 0;

        for (Boar boar : huntedBoars) {
            sum += boar.getW();
        }

        return sum;
    }

}
