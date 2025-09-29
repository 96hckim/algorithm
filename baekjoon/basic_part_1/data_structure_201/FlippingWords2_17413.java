package basic_part_1.data_structure_201;

import java.io.*;

public class FlippingWords2_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean inTag = false; // 태그 안 여부 체크

        for (char c : S.toCharArray()) {
            if (c == '<') {
                // 단어가 있으면 뒤집어서 출력 버퍼에 추가
                result.append(word.reverse());
                word.setLength(0);
                inTag = true;
                result.append(c);
            } else if (c == '>') {
                inTag = false;
                result.append(c);
            } else if (inTag) {
                result.append(c); // 태그 안은 그대로
            } else {
                if (c == ' ') {
                    // 단어 끝나면 뒤집어서 추가
                    result.append(word.reverse());
                    word.setLength(0);
                    result.append(c);
                } else {
                    word.append(c);
                }
            }
        }

        result.append(word.reverse());

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
