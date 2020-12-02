import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> checkMap = new HashMap<>();
        
        for(String value: participant)
            
            //getOrDefault 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환
        	checkMap.put(value, checkMap.getOrDefault(value,0)+1);
        
        for(String value: completion)
        	checkMap.put(value, checkMap.get(value) -1);
        
        for(String key: checkMap.keySet()) {
        	if(checkMap.get(key) != 0)
        		answer = key;
        }
        
        return answer;
    }
}
