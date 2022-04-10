import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> users = new HashMap<>();
        
        for(int i=0; i<record.length; i++) {
            String[] user = record[i].split("\\s");
            if(!user[0].equals("Leave"))
                users.put(user[1], user[2]);
        }
        
        for(int i=0; i<record.length; i++) {
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")) {
                list.add(users.get(s[1]) + "님이 들어왔습니다.");
            }
            else if(s[0].equals("Leave")) {
                list.add(users.get(s[1]) + "님이 나갔습니다.");
            }
        }
        answer = list.toArray(new String[list.size()]);
     
        return answer;
    }
}
