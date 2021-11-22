package CompetencyTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BlackFriday {

    private static class Customer implements Comparable<Customer> {

        int y, x, d;

        public Customer(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Customer c) {
            return this.d - c.d;
        }

        @Override
        public String toString() {
            return "{" +
                    "y=" + y +
                    ", x=" + x +
                    ", d=" + d +
                    '}';
        }

    }

    private static class Store {

        int y, x, p, s;

        public Store(int p, int s) {
            this.p = p;
            this.s = s;
        }

        void setPos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "{" +
                    "y=" + y +
                    ", x=" + x +
                    ", p=" + p +
                    ", s=" + s +
                    '}';
        }

    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int M;
    private static int K;

    private static char[][] department;
    private static ArrayList<Customer> customers;
    private static Store[] stores;

    private static ArrayList<Customer>[] visitStore;
    private static int MIN_TIME;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        department = new char[N][M];
        customers = new ArrayList<>();
        stores = new Store[K];
        visitStore = new ArrayList[K];
        MIN_TIME = Integer.MAX_VALUE;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            stores[i] = new Store(P, S);
        }

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                department[i][j] = arr[j];
                if (department[i][j] != '0') {
                    if (department[i][j] == '1') customers.add(new Customer(i, j));
                    else stores[department[i][j] - 'A'].setPos(i, j);
                }
            }
        }

        for (int i = 0; i < K; i++) visitStore[i] = new ArrayList<>();
    }

    // 출력
    private static void output() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

    // 메인
    public static void main(String[] args) throws IOException {

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input();
            recursive(0);
            bw.write("#" + t + " " + MIN_TIME + "\n");
        }

        output();

    }

    private static void recursive(int x) {

        if (x == customers.size()) {

            int time = getTime();
            if (MIN_TIME > time) MIN_TIME = time;

        } else {

            for (int i = 0; i < K; i++) {
                Customer customer = customers.get(x);
                Store store = stores[i];
                customer.d = Math.abs(customer.y - store.y) + Math.abs(customer.x - store.x);
                visitStore[i].add(customer);
                recursive(x + 1);
                visitStore[i].remove(customer);
            }

        }

    }

    private static int getTime() {
        int time = 0;

        for (int i = 0; i < visitStore.length; i++) {
            ArrayList<Customer> visitCustomers = visitStore[i];
            if (visitCustomers.isEmpty()) continue;
            Collections.sort(visitCustomers);

            int lastIndex = visitCustomers.size() - 1;
            Store store = stores[i];

            int q = lastIndex / store.p;
            int r = lastIndex % store.p;
            int timeStore = visitCustomers.get(r).d + store.s;

            if (q > 0) {
                for (int j = 1; j <= q; j++) {
                    Customer customer = visitCustomers.get(r + store.p * j);
                    if (timeStore > customer.d) timeStore += store.s;
                    else timeStore = customer.d + store.s;
                }
            }

            if (time < timeStore) time = timeStore;
        }

        return time;
    }

}
