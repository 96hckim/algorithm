import java.util.Scanner;

public class SquareRoot {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    for (int i = 0; i <= n; i++) {
      if (i * i >= n) {
        System.out.println(i);
        break;
      }
    }

    scan.close();

  }
  
}
