package Level11;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tower {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] towerArray = new int[n];
        Stack<int[]> towerStack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            towerArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {

            while (!towerStack.isEmpty() && towerStack.peek()[0] < towerArray[i]) towerStack.pop();

            if (towerStack.isEmpty()) bw.write("0 ");
            else bw.write(towerStack.peek()[1] + " ");

            towerStack.push(new int[]{towerArray[i], i + 1});

        }

        br.close();
        bw.flush();
        bw.close();

    }

}
