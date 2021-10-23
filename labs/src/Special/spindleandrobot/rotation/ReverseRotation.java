package Special.spindleandrobot.rotation;

import java.io.*;
import java.util.StringTokenizer;

public class ReverseRotation {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if (x - y < 0) {
            x = n - (y - x);
        } else {
            x = x - y;
        }

        bw.write(arr[x] + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
