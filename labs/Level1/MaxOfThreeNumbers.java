package Level1;

import java.util.Scanner;

public class MaxOfThreeNumbers {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);

    int a = Integer.parseInt(scan.next());
    int b = Integer.parseInt(scan.next());
    int c = Integer.parseInt(scan.next());

    System.out.println(Math.max(Math.max(a, b), c));
    scan.close();

  }
  
}
