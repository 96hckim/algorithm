package Level1;

import java.util.Scanner;

public class CountTheNumberOfMultiples {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);

    int a = Integer.parseInt(scan.next());
    int b = Integer.parseInt(scan.next());
    int c = Integer.parseInt(scan.next());
    int count = 0;

    if (a > b) {
      int temp = a;
      a = b;
      b = temp;
    }

    for (int i = a; i <= b; i++) {

      if (i % c == 0) {
        count++;
      }

    }
    
    System.out.println(count);
    scan.close();

  }
  
}
