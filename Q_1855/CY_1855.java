import java.io.*;
import java.util.Scanner;
public class Q_1855 {
  public static void main(String[] args) throws IOException {
    Scanner st = new Scanner(new InputStreamReader(System.in));
    int column = Integer.parseInt(st.next());
    String data = st.next();

    int row = data.length() / column;
    String[] info = new String[row];

    boolean flag = false;
    int index = 0;
    for (int i = 0; i < data.length(); i = i + column) {
      String tmp = data.substring(i, i + column);

      if (!flag) {
        info[index] = tmp;
        flag = true;
      } else {
        StringBuffer sb = new StringBuffer(tmp);
        String rv = sb.reverse().toString();
        info[index] = rv;
        flag = false;
      }
      index++;
    }

    for (int c = 0; c < column; c++) {
      for (int k = 0; k < row; k++) {
        System.out.print(info[k].charAt(c));  
      } 
    }

  }
}
