package Level3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Car {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int dateNumber = Integer.parseInt(st.nextToken());

        ArrayList<Integer> carNumbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            carNumbers.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(String.valueOf(carNumbers.stream().filter(num -> num == dateNumber).count()));

        br.close();
        bw.flush();
        bw.close();

    }

}