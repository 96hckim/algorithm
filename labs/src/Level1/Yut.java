package Level1;

import java.util.Scanner;

public class Yut {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String line1 = scan.nextLine();
    String line2 = scan.nextLine();
    String line3 = scan.nextLine();
    System.out.println(yut(line1));
    System.out.println(yut(line2));
    System.out.println(yut(line3));

    scan.close();
  }

  public static String yut(String str) {
    int count = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == "0".charAt(0)) {
        count++;
      }
    }

    String result;

    switch(count){
      case 0:
        result = "E";
        break;
      case 1:
        result = "A";
        break;
      case 2:
        result = "B";
        break;
      case 3:
        result = "C";
        break;
      default:
        result = "D";
        break;
    }

    return result.toUpperCase();
  }
}
