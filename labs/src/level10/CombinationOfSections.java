package level10;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Section {

    private long s;
    private long e;

    public Section(long s, long e) {
        this.s = s;
        this.e = e;
    }

    public long getS() {
        return s;
    }

    public void setS(long s) {
        this.s = s;
    }

    public long getE() {
        return e;
    }

    public void setE(long e) {
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

    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    private static int n;
    private static long i;
    private static int result = 0;
    private static ArrayList<Section> sections;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        sections = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (min >= s) min = s;
            if (max <= e) max = e;

            sections.add(new Section(s, e));
        }

        i = Long.parseLong(br.readLine());

        binarySearch(min, max);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void binarySearch(int start, int end) {
        if (start <= end) {
            long sum = 0;
            int mid = (start + end) / 2;

            for (Section section : sections) {
                if (section.getE() <= mid) {
                    sum += section.getE() - section.getS() + 1;
                } else {
                    if (section.getS() == mid) sum++;
                    else if (section.getS() < mid) sum += mid - section.getS() + 1;
                }
            }

            if (sum < i) binarySearch(mid + 1, end);
            else if (sum == i) {
                result = mid + 1;
            } else {
                if (sum > mid) result = mid;
                binarySearch(start, mid - 1);
            }
        }
    }

}
