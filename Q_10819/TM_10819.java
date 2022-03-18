import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TM_10819 {
  public static void main(String[] args) {
    int n;
    int[] a;
    int[] temp;
    boolean[] visited;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    a = new int[n];
    temp = new int[n];
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    sequence(a, n, temp, 0, visited, priorityQueue);
    System.out.println(priorityQueue.poll());
  }

  private static void sequence(int[] a, int n, int[] temp, int index, boolean[] visited,
      PriorityQueue<Integer> priorityQueue) {
    if (index == n) {
      int sum = 0;
      for (int i = 0; i < n - 1; i++) {
        sum += Math.abs(temp[i] - temp[i + 1]);
      }
      priorityQueue.offer(sum);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      temp[index] = a[i];
      sequence(a, n, temp, index + 1, visited, priorityQueue);
      visited[i] = false;
    }
  }
}