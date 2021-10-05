package Level1;

import java.util.Scanner;

/**
 * PrimeNumber
 */
public class PrimeNumber {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int count = 0;
    String result;

    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        count++;
      }
    }

    if (count == 2) {
      result = "YES";
    } else {
      result = "NO";
    }

    System.out.println(result);
    scan.close();

  }
  
}