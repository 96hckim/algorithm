package basic_part_1.data_structure_200;

import java.io.*;
import java.util.ArrayList;

public class FlippingWords2_17413 {
    enum StringType {
        WORD, TAG
    }

    static class FlippingWord {
        StringType type;
        StringBuilder sb;

        public FlippingWord(StringType type, StringBuilder sb) {
            this.type = type;
            this.sb = sb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        ArrayList<FlippingWord> words = new ArrayList<>();
        FlippingWord fw = null;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            switch (c) {
                case ' ':
                    if (fw != null) {
                        if (fw.type == StringType.WORD) {
                            words.add(fw);
                            fw = null;
                            words.add(new FlippingWord(StringType.TAG, new StringBuilder(" ")));
                        } else {
                            fw.sb.append(" ");
                        }
                    }
                    break;
                case '<':
                    if (fw != null) {
                        words.add(fw);
                    }
                    fw = new FlippingWord(StringType.TAG, new StringBuilder("<"));
                    break;
                case '>':
                    if (fw != null) {
                        fw.sb.append(">");
                        words.add(fw);
                        fw = null;
                    }
                    break;
                default:
                    if (fw == null) {
                        fw = new FlippingWord(StringType.WORD, new StringBuilder());
                    }
                    fw.sb.append(c);
                    break;
            }
        }

        if (fw != null) {
            words.add(fw);
        }

        for (FlippingWord word : words) {
            if (word.type == StringType.WORD) {
                word.sb.reverse();
            }
            bw.write(word.sb.toString());
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
