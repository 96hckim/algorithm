package Level2;

import java.util.Arrays;
import java.util.Scanner;

public class Array2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] sizeArr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] valueArr = new int[sizeArr[0]][sizeArr[1]];

        for (int i = 0; i < sizeArr[0]; i++) {
            valueArr[i] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int x = Integer.parseInt(scan.next());
        int y = Integer.parseInt(scan.next());

        System.out.println(valueArr[x][y]);

    }

}
