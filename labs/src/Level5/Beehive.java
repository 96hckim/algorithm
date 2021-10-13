package Level5;

import java.io.*;

public class Beehive {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int room = 1;

        if (n > 1) {
            int sequence = 6;
            int count = 0;
            int range = 1;

            do {
                room++;
                count++;
                range += sequence * count;
            } while (n > range);
        }

        bw.write(room + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
