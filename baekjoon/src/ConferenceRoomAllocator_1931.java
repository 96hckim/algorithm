package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ConferenceRoomAllocator_1931 {
    private static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start; // 끝나는 시간이 같으면 시작 시간 오름차순
            }
            return this.end - o.end; // 끝나는 시간 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings); // 정렬

        int count = 0;
        int lastEnd = 0;

        for (Meeting meeting : meetings) {
            if (meeting.start >= lastEnd) { // 이전 회의 끝난 후 시작 가능
                count++;
                lastEnd = meeting.end;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        br.close();
        bw.close();
    }
}
