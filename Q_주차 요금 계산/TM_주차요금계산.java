import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

class Solution {
  public int[] solution(int[] fees, String[] records) {
    int[] answer;
    TreeMap<String, String> map = new TreeMap<>();

    for (int i = 0; i < records.length; i++) {
      String[] record = records[i].split(" ");
      String time = record[0];
      String car = record[1];
      if (map.containsKey(car)) {
        map.put(car, map.get(car) + " " + time);
      } else {
        map.put(car, time);
      }
    }

    answer = new int[map.keySet().size()];
    int i = 0;

    for (String car : map.keySet()) {
      ArrayList<String> times = new ArrayList<>(Arrays.asList(map.get(car).split(" ")));
      int usageTime = 0;
      if (times.size() % 2 == 1) {
        times.add("23:59");
      }

      for (int j = 0; j < times.size(); j += 2) {
        usageTime += getUsageTime(times.get(j), times.get(j + 1));
      }
      answer[i] = getCost(usageTime, fees);
      i++;
    }
    return answer;
  }

  public static int getUsageTime(String in, String out) {
    String[] temp = in.split(":");
    int inTime = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);

    temp = out.split(":");
    int outTime = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);

    int usageTime = outTime - inTime;
    return usageTime;
  }

  public static int getCost(int usageTime, int[] fees) {
    int baseTime = fees[0];
    int baseCost = fees[1];
    int unitTime = fees[2];
    int unitCost = fees[3];
    int cost = 0;
    if (usageTime <= baseTime) {
      return baseCost;
    } else {
      usageTime -= baseTime;
      cost += baseCost;
      if (usageTime % unitTime > 0) {
        usageTime = (usageTime / unitTime) + 1;
      } else {
        usageTime = (usageTime / unitTime);
      }
      cost += unitCost * usageTime;
    }
    return cost;
  }
}