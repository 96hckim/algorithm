package level8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dessert {

    private static int n;
    private static String[] napkinArray;
    private static final String[] napkinTypeArray = {"+", "-", "."};
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        napkinArray = new String[n - 1];

        dessert(0);
        System.out.println(count);

    }

    private static void dessert(int x) {

        if (x == napkinArray.length) {

            ArrayList<Integer> numberList = new ArrayList<>();
            numberList.add(1);

            for (int i = 0; i < napkinArray.length; i++) {
                if (napkinArray[i].equals(".")) {
                    String combineString = numberList.get(numberList.size() - 1) + "" + (i + 2);
                    if (combineString.length() >= 10) return;

                    numberList.remove(numberList.size() - 1);
                    numberList.add(Integer.parseInt(combineString));
                } else {
                    numberList.add(i + 2);
                }

            }

            int sum = numberList.get(0);
            int i = 1;

            for (String napkin : napkinArray) {
                switch (napkin) {
                    case "+":
                        sum += numberList.get(i);
                        i++;
                        break;
                    case "-":
                        sum -= numberList.get(i);
                        i++;
                        break;
                    default:
                        break;
                }
            }

            if (sum == 0) {
                count++;

                if (count <= 20) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(1);

                    for (int j = 0; j < napkinArray.length; j++) {
                        sb.append(" ")
                                .append(napkinArray[j])
                                .append(" ")
                                .append(j + 2);
                    }

                    System.out.println(sb);
                }
            }

        } else {

            for (int i = 0; i < 3; i++) {
                napkinArray[x] = napkinTypeArray[i];

                x++;
                dessert(x);
                x--;
            }

        }

    }

}
