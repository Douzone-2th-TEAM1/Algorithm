import java.io.*;

public class App {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String[] str = br.readLine().split("");
      System.out.println(palindrome(str));
    }
  }

  public static int palindrome(String[] w) {
    int result = 0;
    int front = 0;
    int rear = w.length - 1;

    while (front < rear) {
      if (w[front].equals(w[rear])) {
        front++;
        rear--;
      } else {
        //회문이 아니면 
        int left = front, right = rear;

        left++;
        while (left < right) {
          if (w[left].equals(w[right])) {
            left++;
            right--;
          } else {
            result++;
            break; // 다 확인할 필요가 없음
          }
        }

        left = front;
        right = rear;
        right--;
        while (left < right) {
          if (w[left].equals(w[right])) {
            left++;
            right--;
          } else {
            result++;
            break; // 다 확인할 필요가 없음
          }
        }

        return result;
      }

    }
    return result;
  }
}
