package Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SecondMinimum {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            arr.add(scan.nextInt());
        }

        ArrayList<Integer> origin = (ArrayList<Integer>) arr.clone();

        Collections.copy(origin, arr);

        Collections.sort(arr);

        int min = arr.get(1);
        System.out.println(min);
        System.out.println(origin.indexOf(min) + 1);

    }

}
