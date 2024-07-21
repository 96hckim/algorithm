package Level10;

import java.io.*;
import java.util.StringTokenizer;

class Section {

    private int s;
    private int e;

    public Section(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return "Section{" +
                "s=" + s +
                ", e=" + e +
                '}';
    }

}

public class CombinationOfSections {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int n = Integer.parseInt(br.readLine());

        Section[] sections = new Section[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (min > s) min = s;
            if (max < e) max = e;

            sections[i] = new Section(s, e);
        }

        long i = Long.parseLong(br.readLine());

        int start = min;
        int end = max + 1;

        while (start + 1 < end) {

            int mid = (start + end) / 2;

            long count = 0;

            for (Section section : sections) {
                if (section.getE() < mid) count += section.getE() - section.getS() + 1;
                else {
                    if (section.getS() <= mid) count += mid - section.getS();
                }
            }

            if (count <= i) start = mid;
            else end = mid;

        }

        bw.write(start + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
