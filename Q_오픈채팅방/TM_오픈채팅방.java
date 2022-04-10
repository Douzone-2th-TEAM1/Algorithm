import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public String[] solution(String[] record) {
    String[] answer;
    HashMap<String, String> map = new HashMap<>();
    Queue<String[]> queue = new LinkedList<>();

    for (int i = 0; i < record.length; i++) {
      String[] temp = record[i].split(" ");
      String state = temp[0];
      String uid = temp[1];
      String nickname;
      String[] msg = new String[2];

      switch (state) {
        case "Enter":
          nickname = temp[2];
          msg[1] = uid;
          msg[0] = "님이 들어왔습니다.";
          queue.offer(msg);
          map.put(uid, nickname);
          break;
        case "Leave":
          msg[1] = uid;
          msg[0] = "님이 나갔습니다.";
          queue.offer(msg);
          break;
        case "Change":
          nickname = temp[2];
          map.put(uid, nickname);
          break;
        default:
          break;
      }
    }

    answer = new String[queue.size()];
    int i = 0;

    while (!queue.isEmpty()) {
      String[] msg = queue.poll();
      answer[i] = map.get(msg[1]) + msg[0];
      i++;
    }

    return answer;
  }
}