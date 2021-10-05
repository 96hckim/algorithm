package Level1;

import java.util.Scanner;

/**
 * AplusB
 */
public class AplusB {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int a = Integer.parseInt(scan.next());
    int b = Integer.parseInt(scan.next());
    scan.close();

    System.out.print(a+b);

  }
  
}