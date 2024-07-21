package Level11;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Dish {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] alphabetArray = br.readLine().toCharArray();
        ArrayList<String> resultList = new ArrayList<>();
        Stack<Character> myStack = new Stack<>();

        boolean isPossible;
        int cursor = 0;
        char currentAlpha = 'a';

        while (true) {

            char topElement = myStack.isEmpty() ? 0 : myStack.peek();
            char currentElement = alphabetArray[cursor];

            if (topElement == currentElement) {
                myStack.pop();
                resultList.add("pop");
                cursor++;

                if (cursor == alphabetArray.length) {
                    isPossible = true;
                    break;
                }
            } else {
                if (currentAlpha - 'a' == alphabetArray.length) {
                    isPossible = false;
                    break;
                }

                myStack.push(currentAlpha);
                resultList.add("push");
                currentAlpha++;
            }

        }

        if (isPossible) {
            for (String result : resultList) {
                bw.write(result + "\n");
            }
        } else {
            bw.write("impossible");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
