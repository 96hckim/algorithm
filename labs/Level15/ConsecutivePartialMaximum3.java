package Level15;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 분할 정복 NlogN
 */
public class ConsecutivePartialMaximum3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>(n);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        int maximum = getMaximum(arrayList);

        bw.write(maximum + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int getMaximum(ArrayList<Integer> arrayList) {

        if (arrayList.size() == 0) return 0;
        if (arrayList.size() <= 1) return arrayList.get(0);

        int mid = arrayList.size() / 2;

        int leftMax = getMaximum(new ArrayList<>(arrayList.subList(0, mid)));
        int rightMax = getMaximum(new ArrayList<>(arrayList.subList(mid, arrayList.size())));

        int midLeftSum = 0;
        int midLeftMax = Integer.MIN_VALUE;

        for (int i = mid - 1; i >= 0; i--) {
            midLeftSum += arrayList.get(i);
            if (midLeftMax < midLeftSum) midLeftMax = midLeftSum;
        }

        int midRightSum = 0;
        int midRightMax = Integer.MIN_VALUE;

        for (int i = mid; i < arrayList.size(); i++) {
            midRightSum += arrayList.get(i);
            if (midRightMax < midRightSum) midRightMax = midRightSum;
        }

        int midMax = midLeftMax + midRightMax;

        return Math.max(Math.max(leftMax, rightMax), midMax);

    }

}
