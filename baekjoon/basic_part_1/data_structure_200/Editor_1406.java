package basic_part_1.data_structure_200;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Editor_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> editor = new LinkedList<>();

        String initial = br.readLine();
        for (char c : initial.toCharArray()) {
            editor.add(c);
        }

        ListIterator<Character> listIterator = editor.listIterator(editor.size());

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "L" -> {
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                }
                case "D" -> {
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                }
                case "B" -> {
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                }
                case "P" -> {
                    char c = st.nextToken().charAt(0);
                    listIterator.add(c);
                }
            }
        }

        for (Character c : editor) {
            bw.write(c);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
