import java.util.*;

class Tuple{
    String carNumber;
    String inputTime;
    
    Tuple(String c, String t){
        this.carNumber = c;
        this.inputTime = t;
    }
    
    public void print(){
        System.out.println(carNumber + ", " + inputTime);
    }
    
}

class Solution {
    public int convertTime(String start, String end){
        String[] s = start.split(":");
        String[] e = end.split(":");
        int s_m = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        int e_m = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
        return Math.abs(e_m-s_m);
    }
    
    public int[] solution(int[] fees, String[] records) {
        // fees[0]: 기본시간(분) ,fees[1]: 기본요금 (원), fees[2]: 단위시간(분), fees[3]:단위요금(원)
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>(); // 차량번호, 누적시간
        ArrayList<Tuple> stack = new ArrayList<>();
        
        for(String item : records){
            String[] info = item.split(" "); // 시간, 차량번호, 내역
            if(info[2].equals("IN")){ // 입차
                stack.add(new Tuple(info[1],info[0]));
            }else{ // 출차
                for(int i=0; i<stack.size(); i++){
                    Tuple tmp ;
                    if(stack.get(i).carNumber.equals(info[1])){
                        tmp = stack.remove(i); // 차량번호, 입차시각
                        int parkTime = convertTime(tmp.inputTime, info[0]);
                        map.put(info[1], map.getOrDefault(info[1], 0) + parkTime);
                        
                    }
                    
                }
            }
         }
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                 Tuple tmp = stack.remove(0); // 차량번호, 입차 시각
                int parkTime = convertTime(tmp.inputTime, "23:59");
                map.put(tmp.carNumber, map.getOrDefault(tmp.carNumber, 0) + parkTime);
            }
           
        }
        
        for(String key : map.keySet()){
            int price = (int)fees[1] + ((int)(Math.ceil((map.get(key) >= fees[0] ? (map.get(key) - fees[0]) : 0)/(double)fees[2])) * fees[3]);
            map.put(key, price);
        }
        Object[] mapKey = map.keySet().toArray();
        Arrays.sort(mapKey);
        
        
        answer = new int[mapKey.length];
        for(int i=0; i<mapKey.length; i++){
            answer[i] = map.get(mapKey[i]);
        }

        return answer;
    } 
}
