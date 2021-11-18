package CompetencyTest;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gear {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static ArrayList<String[]> commands; // 회전 명령
    private static int[][] gear; // 4개의 톱니바퀴의 극
    private static final int[] index = {0, 1, 4, 2, 3}; // 톱니바퀴 번호에 따라 인덱스 리턴
    private static StringBuilder result; // 결과값(1번 상단, 2번 좌측, 3번 우측, 4번 하단 극)

    // 입력
    private static void input() throws IOException {
        int K = Integer.parseInt(br.readLine());
        result = new StringBuilder();

        // 회전 명령 초기화
        commands = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) commands.add(st.nextToken().split(""));

        // 톱니바퀴별 극 초기화
        gear = new int[5][8];
        for (int i = 1; i <= 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) gear[index[i]][j] = Integer.parseInt(st.nextToken());
        }

        // 시작 인덱스 변경
        for (int i = 0; i < 2; i++) forward(index[2]); // 2번 톱니바퀴 좌측
        for (int i = 0; i < 2; i++) reverse(index[3]); // 3번 톱니바퀴 우측
        for (int i = 0; i < 4; i++) reverse(index[4]); // 4번 톱니바퀴 하단
    }

    // 정방향 회전
    private static void forward(int num) {
        int temp = gear[num][7];
        for (int i = 7; i > 0; i--) gear[num][i] = gear[num][i - 1];
        gear[num][0] = temp;
    }

    // 역방향 회전
    private static void reverse(int num) {
        int temp = gear[num][0];
        for (int i = 0; i < 7; i++) gear[num][i] = gear[num][i + 1];
        gear[num][7] = temp;
    }

    // 출력
    private static void output() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

    // 메인
    public static void main(String[] args) throws IOException {

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input();
            for (String[] command : commands) { // 회전 명령 순차 실행
                int gearNum = Integer.parseInt(command[0]); // 톱니바퀴 번호
                int direction = command[1].equals("+") ? 1 : -1; // 회전 방향
                rotationCheck(index[gearNum], direction);
            }
            getResult();
            bw.write("#" + t + " " + result + "\n"); // 결과 출력
        }

        output();

    }

    // 회전해야할 톱니바퀴 확인하고 회전 방향 지정
    private static void rotationCheck(int num, int direction) {
        int[] rotationList = new int[5]; // 톱니바퀴 회전 리스트
        rotationList[num] = direction;

        int front = num + 1 > 4 ? 1 : num + 1; // 앞
        int back = num - 1 < 1 ? 4 : num - 1; // 뒤
        int opposite = front + 1 > 4 ? 1 : front + 1; // 반대

        // 앞 톱니바퀴
        if (gear[num][3] != gear[front][5]) {
            rotationList[front] = direction * -1;
            if (gear[front][3] != gear[opposite][5]) {
                rotationList[opposite] = direction;
                if (gear[opposite][3] != gear[back][5]) {
                    rotationList[back] = direction * -1;
                }
            }
        }

        // 뒤 톱니바퀴
        if (gear[num][5] != gear[back][3]) {
            rotationList[back] = direction * -1;
            if (gear[back][5] != gear[opposite][3]) {
                rotationList[opposite] = direction;
                if (gear[opposite][5] != gear[front][3]) {
                    rotationList[front] = direction * -1;
                }
            }
        }

        rotation(rotationList);
    }

    // 톱니바퀴 회전
    private static void rotation(int[] rotationList) {
        for (int i = 1; i <= 4; i++) {
            if (rotationList[i] == 1) forward(i);
            else if (rotationList[i] == -1) reverse(i);
        }
    }

    // 결과
    private static void getResult() {
        for (int i = 1; i <= 4; i++) result.append(gear[index[i]][0]).append(" ");
    }

}
