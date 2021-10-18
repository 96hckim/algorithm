package level8;

import java.util.ArrayList;
import java.util.Scanner;

public class Dessert {

    private static int n;
    private static int resultCount = 0;
    private static String[] napkinArray = {"+", "-", "."};
    private static ArrayList<String> napkinList = new ArrayList<>();
    private static ArrayList<Integer> numberList;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        printResult(1);
        System.out.println(resultCount);

    }

    private static void printResult(int number) {

        if (number == n) {

            // 숫자 배열 초기화
            numberList = new ArrayList<>();
            numberList.add(1);

            // (.) 숫자 합쳐줌
            for (int i = 0; i < napkinList.size(); i++) {
                if (napkinList.get(i).equals(".")) {
                    int prevNum = numberList.get(numberList.size() - 1);
                    numberList.remove(numberList.size() - 1);
                    String connectString = prevNum + "" + (i + 2);
                    if (connectString.length() >= 10) return;
                    numberList.add(Integer.parseInt(connectString));
                } else {
                    numberList.add(i + 2);
                }
            }

            // 합계
            int sum = numberList.get(0);

            for (int i = 0, x = 1; i < napkinList.size(); i++) {
                switch (napkinList.get(i)) {
                    case "+":
                        sum += numberList.get(x);
                        x++;
                        break;
                    case "-":
                        sum -= numberList.get(x);
                        x++;
                        break;
                    default:
                        break;
                }
            }

            if (sum == 0) {
                resultCount++;
                // 20줄만 출력
                if (resultCount <= 20) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(1);
                    for (int i = 0; i < napkinList.size(); i++) {
                        sb.append(" ")
                                .append(napkinList.get(i))
                                .append(" ")
                                .append(i + 2);
                    }
                    System.out.println(sb);
                }
            }

        } else {

            for (int i = 0; i < napkinArray.length; i++) {
                napkinList.add(napkinArray[i]);
                number++;
                printResult(number);
                number--;
                napkinList.remove(napkinList.size() - 1);
            }

        }

    }

}
