import java.util.*;

class Solution {

    public Map<String, Integer> temp = new HashMap<>();
    public Map<String, Integer> parkTime;

    public int[] solution(int[] fees, String[] records) {

        Comparator<String> comparator = (o1, o2) -> o1.compareTo(o2);
        parkTime = new TreeMap<>(comparator);

        for (int i = 0; i < records.length; i++) {
            String[] data = records[i].split(" ");
            if (data[2].equals("IN")) {
                int time = parsingTime(data[0]);
                temp.put(data[1], time);
            } else {
                int end = parsingTime(data[0]);
                int start = temp.get(data[1]);
                parkTime.put(data[1], parkTime.getOrDefault(data[1], 0) + end - start);
                temp.remove(data[1]);
            }
        }
        for (String car : temp.keySet()) {
            int start = temp.get(car);
            int end = parsingTime("23:59");
            parkTime.put(car, parkTime.getOrDefault(car, 0) + end - start);
        }

        int[] answer = new int[parkTime.size()];
        int idx = 0;
        for (String car : parkTime.keySet()) {
            int pay = countFee(fees, parkTime.get(car));
            answer[idx++] = pay;
        }
        return answer;
    }

    public int countFee(int[] fees, int time) {
        if (time <= fees[0]) {
            return fees[1];
        } else {
            time -= fees[0];
            return fees[1] + ((int) Math.ceil((double) time / fees[2]) * fees[3]);
        }
    }

    public int parsingTime(String times) {
        String[] time = times.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}
