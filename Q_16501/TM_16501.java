import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TM_16501 {
  public static PriorityQueue<Double> pq1 = new PriorityQueue<>();
  public static PriorityQueue<Double> pq2 = new PriorityQueue<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] satisfaction = new int[8];
    boolean[] visited = new boolean[8];

    for (int i = 0; i < 8; i++) {
      satisfaction[i] = sc.nextInt();
    }

    chooseCourt(satisfaction, 0, 8, 4, visited);
    System.out.println(pq2.poll());
    sc.close();
  }

  public static void chooseCourt(int[] satisfaction, int index, int n, int r, boolean[] visited) {
    if (r == 0) {
      ArrayList<Integer> court1 = new ArrayList<>();
      ArrayList<Integer> court2 = new ArrayList<>();
      for (int i = 0; i < visited.length; i++) {
        if (visited[i])
          court1.add(satisfaction[i]);
        else
          court2.add(satisfaction[i]);
      }
      check(court1, pq1);
      check(court2, pq2);
      return;
    }
    for (int i = index; i < n; i++) {
      visited[i] = true;
      chooseCourt(satisfaction, i + 1, n, r - 1, visited);
      visited[i] = false;
    }
  }

  public static void check(ArrayList<Integer> court, PriorityQueue<Double> pq) {
    boolean[] visited = new boolean[4];
    double sat = 0;
    for (int i = 0; i < 3; i++) {
      visited[i] = true;
      for (int j = i + 1; j < 4; j++) {
        visited[j] = true;
        double teamA = 0, teamB = 0;
        for (int k = 0; k < 4; k++) {
          if (visited[k]) {
            teamA += court.get(k);
            System.out.print(court.get(k) + "A ");
          } else {
            teamB += court.get(k);
            System.out.print(court.get(k) + "B ");
          }
          sat = 1 - (Math.abs((teamA / 2) - (teamB / 2)) / 10);
          
          pq.offer(sat);
        }
        System.out.println(sat);

        visited[j] = false;
      }
      visited[i] = false;
    }
  }

}