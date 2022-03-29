import java.io.*;
import java.util.*;
import java.util.Arrays.*;

public class App {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    String s = sc.next();
    
    String[] str = s.split("-");
    ArrayList<Integer> infos = new ArrayList<Integer>();
    int answer = 0;
    
    for(String item : str){
      int[] data = Arrays.stream(item.split("\\+")).mapToInt(Integer::parseInt).toArray();
      int sum = Arrays.stream(data).parallel().reduce(0,(a,b)-> a+b); // 배열의 합 구하기
      item = Integer.toString(sum);

      infos.add(Integer.parseInt(item));
    }

    answer = infos.get(0);
    for(int i=1; i<infos.size();i++){
      answer-=infos.get(i);
    }

    System.out.println(answer);
  }
}
