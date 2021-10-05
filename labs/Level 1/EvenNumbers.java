import java.util.Scanner;

public class EvenNumbers {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = Integer.parseInt(scan.next());
    String result;

    if (n % 2 == 0) {
      result = "even";
    } else {
      result = "not even";
    }

    System.out.println(result);
    scan.close();
  }
}
