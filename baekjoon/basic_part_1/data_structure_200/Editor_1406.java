package basic_part_1.data_structure_200;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Editor_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String initString = br.readLine();
        LinkedList<Character> editor = new LinkedList<>();

        for (int i = 0; i < initString.length(); i++) {
            editor.add(initString.charAt(i));
        }

        ListIterator<Character> listIterator = editor.listIterator(editor.size());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            switch (command) {
                case 'L':
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                    break;
                case 'D':
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                    break;
                case 'B':
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                    break;
                case 'P':
                    listIterator.add(st.nextToken().charAt(0));
                    break;
            }
        }

        for (Character c : editor) {
            bw.write(c);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
