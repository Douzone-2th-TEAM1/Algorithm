import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class App {
  public static int L, C;

  public static String[] alpha;
  public static ArrayList<String> vowel = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
  public static ArrayList<String> consonat = new ArrayList<>(Arrays.asList("b", "c", "d", "f", "g", "h", "j", "k", "l",
      "m", "n", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"));
  public static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    L = input[0];
    C = input[1];
    alpha = br.readLine().split(" ");
    Arrays.sort(alpha);

    ArrayList<String> results = new ArrayList<>();
    dfs(0, results);
    System.out.println(sb); 
  }
  
  public static void dfs(int depth, ArrayList<String> arr) {
    
    if (arr.size() >= L || depth > C) {
      boolean vflag = false; int cflag = 0;
      for (int i = 0; i < arr.size(); i++) {
        if (vowel.contains(arr.get(i))) {
          vflag = true;
        }

        if (consonat.contains(arr.get(i))) {
          cflag++;
        }

        if (vflag && cflag >= 2) {
          sb.append(String.join("", arr)+"\n");
          break;
        }
      }
  
      return;
    }
    
    for (int i = depth; i < C; i++) {
      if(arr.contains(alpha[i])) continue;
      arr.add(alpha[i]);
      dfs(i, arr);
      arr.remove(arr.size() - 1);
    }
  }
}
