package Level11;

import java.io.*;
import java.util.Stack;

public class Bracket {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] bracketArray = br.readLine().split("");
        Stack<String> myStack = new Stack<>();

        boolean isVPS = true;

        for (String bracket : bracketArray) {
            switch (bracket) {
                case "(":
                    myStack.push(bracket);
                    break;
                case ")":
                    if (myStack.isEmpty()) {
                        isVPS = false;
                        break;
                    }
                    myStack.pop();
                    break;
            }
        }

        if (isVPS && myStack.isEmpty()) bw.write("YES");
        else bw.write("NO");

        br.close();
        bw.flush();
        bw.close();

    }

}
