import java.util.Scanner;

public class FindFactor {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);

    int n = Integer.parseInt(scan.next());
    int k = Integer.parseInt(scan.next());
    int count = 0;
    int result = 0;

    for (int i = 1; i <= n; i++) {

      if (n % i == 0) {
        count++;
        if (count == k) {
          result = i;
          break;
        }
      }

    }
    
    System.out.println(result);
    scan.close();

  }
  
}
