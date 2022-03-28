import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    String s = sc.next();
    String alpha = "abcdefghijklmnopqrstuvwxyz";

    for(int i=0; i<alpha.length(); i++){
      sb.append(s.indexOf(alpha.charAt(i)) + " ");
    }

    System.out.println(sb);
  }
}
