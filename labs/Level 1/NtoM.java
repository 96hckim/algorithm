import java.util.Scanner;

public class NtoM {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    
    int n = Integer.parseInt(scan.next());
    int m = Integer.parseInt(scan.next());
    int count = 0;

    for (int i = n; i <= m; i++) {
      System.out.print(i + " ");
      count++;
      if (count % 8 == 0) {
        System.out.println();
      }
    }

    scan.close();

  }
  
}
