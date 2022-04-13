import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Q_2309 {
  public static ArrayList<Integer> dwarves;
  public static ArrayList<Integer> answer;


  public static Integer sum(ArrayList<Integer> arr) {
    int result = 0;
    for (int item : arr) {
      result += item;
    }
    return result;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    dwarves = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      dwarves.add(Integer.parseInt(br.readLine()));
    }
    Collections.sort(dwarves);
    int currentSum = sum(dwarves);
    int spyA = 0;
    int spyB = 0;
    for (int i = 0; i < dwarves.size()-1; i++) {
      for (int j = i+1; j < dwarves.size(); j++) {
        int tmp = dwarves.get(i) + dwarves.get(j);
        if (currentSum - tmp == 100) {
          spyA = i;
          spyB = j;
          break;
        }
      }
    }
    for (int k = 0; k < dwarves.size(); k++) {
      if (k == spyA || k == spyB)
        continue;
      System.out.println(dwarves.get(k));
    }
  }
}

