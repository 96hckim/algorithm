package Level2;

import java.util.Arrays;
import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxReward = 0;

        for (int i = 0; i < n; i++) {
            int reward;

            if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                reward = 10000 + arr[i][1] * 1000;
            } else if (arr[i][0] == arr[i][1] || arr[i][1] == arr[i][2]) {
                reward = 1000 + arr[i][1] * 100;
            } else if (arr[i][0] == arr[i][2]) {
                reward = 1000 + arr[i][0] * 100;
            } else {
                reward = Arrays.stream(arr[i]).max().getAsInt() * 100;
            }

            if (reward > maxReward) {
                maxReward = reward;
            }
        }

        System.out.println(maxReward);

    }

}
