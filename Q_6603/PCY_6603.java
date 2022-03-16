import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static int K;
  public static int[] Lottos;
  public static StringBuffer sb ;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    while(true){
      Lottos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      if (Lottos[0] == 0)
        System.exit(0);
        
      ArrayList<Integer> result = new ArrayList<>();
      sb = new StringBuffer();
      K = Lottos[0];
      dfs(1, result) ;
      System.out.println(sb);
    }
  }
  

    public static void dfs(int depth,  ArrayList<Integer> array){
      if(depth > K || array.size() > 6){
        if(array.size() == 6) {
          sb.append(array.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
        }
        return;
      } 

      array.add(Lottos[depth]);
      dfs(depth+1, array);
      array.remove(array.size()-1);
      dfs(depth+1, array);
    
  }
}
