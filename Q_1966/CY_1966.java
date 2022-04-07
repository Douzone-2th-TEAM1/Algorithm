import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


class Tuple  {
  private int priority;
  private int index;

  Tuple(int x, int y) {
    this.priority = x;
    this.index = y;
  }
  
  public int getPriority() {
    return priority;
  }

  public int getIndex() {
    return index;
  }

  public void print(){
    System.out.println(priority +", " + index);
  }

}


public class Q_1966 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int[] infos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int N = infos[0];
      int pos = infos[1];

      int[] important = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      priority(important,pos);
    }
  }
  


  public static void priority(int[] array, int targetIdx) {
    int count = 0;
    Queue<Tuple> p = new LinkedList<>();
    for (int i = 0; i < array.length; i++) {
      p.add(new Tuple(array[i], i));
    }

  
    while (!p.isEmpty()) {
      Tuple e = p.remove(); // 원소 하나 꺼냄
      boolean check = true;

      Iterator it = p.iterator();
      
      while (it.hasNext()) {
        Tuple v = (Tuple) it.next();

        if (v.getPriority() > e.getPriority()) { // 현재 원소보다 더 큰 우선 순위가 있다.
          check = false;
          break;
        }
      }
      
      if (!check) {
        p.add(e); // 원소 다시 넣음 
      }
      else {
        count++;
        
        if (e.getIndex() == targetIdx) {
          System.out.println(count);
        }
      
      }
      

    }
  } 
}
