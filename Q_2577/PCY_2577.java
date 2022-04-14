import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q_2577 {

  public static String getMultiple(ArrayList<Integer> arr) {
    int answer = 1;
    for (int item : arr) {
      answer *= item;
    }
    return Integer.toString(answer);
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> info = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < 3; i++) {
      info.add(Integer.parseInt((br.readLine())));
    }

    for (int i = 0; i < 10; i++) {
      map.put(Integer.toString(i), 0);
    }
    for (String item : getMultiple(info).split("")) {
      map.put(item, map.getOrDefault(item, 0) + 1);
    }
    
    for (int i : map.values()) {
      System.out.println(i);
    }
  }
}
