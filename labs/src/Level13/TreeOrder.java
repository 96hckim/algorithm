package Level13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeOrder {

    private static int[][] treeArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        treeArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            treeArray[a][0] = b;
            treeArray[a][1] = c;
        }

        inOrder(0);
        System.out.println();
        preOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();

        br.close();

    }

    private static void inOrder(int n) {
        if (n == -1) return;
        System.out.print(n + " ");
        inOrder(treeArray[n][0]);
        inOrder(treeArray[n][1]);
    }

    private static void preOrder(int n) {
        if (n == -1) return;
        preOrder(treeArray[n][0]);
        System.out.print(n + " ");
        preOrder(treeArray[n][1]);
    }

    private static void postOrder(int n) {
        if (n == -1) return;
        postOrder(treeArray[n][0]);
        postOrder(treeArray[n][1]);
        System.out.print(n + " ");
    }

}
