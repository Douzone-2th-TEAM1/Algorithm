import java.io.*;
import java.util.*;

public class Q_5635 {
  
  static class Birthday implements Comparable<Birthday> {
    String name;
    int month;
    int day;
    int year;

    public Birthday(String name, Integer month, Integer day, Integer year) {
      this.name = name;
      this.month = month;
      this.day = day;
      this.year = year;
    }


    public  String toString(){
      return name;
    }


    @Override
    public int compareTo(Birthday e) {
      if (e.year > this.year) {
        return 1;
      } else if (e.year < this.year) {
        return -1;
      }
      else if (e.month > this.month) {
        return 1;
      }
      else if (e.month < this.month) {
        return -1;
      } else if (e.day > this.day) {
        return 1;
      }
      return -1;
    }
    
    
  }

  public static void main(String[] args)  throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
          ArrayList<Birthday> arr = new ArrayList<>();
      
    
          for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            Birthday b = new Birthday(tmp[0], Integer.parseInt(tmp[2]), Integer.parseInt(tmp[1]),
                Integer.parseInt(tmp[3]));
            arr.add(b);
          }
    
          arr.sort(Comparator.naturalOrder());
          System.out.println(arr.get(0));
          System.out.println(arr.get(arr.size()-1));
  
  }
}
