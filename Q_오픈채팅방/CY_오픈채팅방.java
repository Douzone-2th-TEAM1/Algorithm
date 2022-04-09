import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        Map<String, String> msg = new HashMap<>(){{
            put("Enter", "들어왔습니다.");
            put("Leave", "나갔습니다.");       
        }};
        
        for(String r : record){
          String[] info = r.split(" ");
          if(!info[0].equals("Leave")) map.put(info[1], info[2]);
        }
        
        for(String r : record){
            String[] info = r.split(" ");
            if(!info[0].equals("Change")){
                result.add(map.get(info[1]) +"님이 " + msg.get(info[0]) );
            }
        }
        answer = new String[result.size()];
        result.toArray(answer);
        
        return answer;
    }
}
