import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TM_1759 {
  public static int L, C;
  public static boolean[] visited;
  public static ArrayList<String> vowel = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
  public static HashMap<String, Integer> map = new HashMap<>();

  public static void main(String[] args) throws IOException {
    String[] strings;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    strings = new String[C];
    visited = new boolean[C];

    for (int i = 0; i < C; i++) {
      strings[i] = st.nextToken();
    }
    Arrays.sort(strings);

    combination(strings, 0, L, "");
  }

  public static void combination(String[] strings, int index, int r, String prefix) {
    if (r == 0) {
      boolean hasVowel = false;
      int consonant = 0;
      for (String ch : map.keySet()) {
        if (map.get(ch) > 0) {
          if (isVowel(ch)) {
            hasVowel = true;
          } else
            consonant++;
        }
      }
      if (hasVowel && consonant >= 2) {
        System.out.println(prefix);
      }
      return;
    }
    for (int i = index; i < C; i++) {
      visited[i] = true;
      map.put(strings[i], map.getOrDefault(strings[i], 0) + 1);
      combination(strings, i + 1, r - 1, prefix + strings[i]);
      map.put(strings[i], map.get(strings[i]) - 1);
      visited[i] = false;
    }
  }

  public static boolean isVowel(String ch) {
    if (vowel.contains(ch))
      return true;
    else
      return false;
  }
}