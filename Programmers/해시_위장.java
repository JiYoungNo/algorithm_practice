import java.util.*;
import java.util.Map.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap<String, Integer>();
    
        for(int i=0; i< clothes.length ; i++) {
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key,0)+1);
        }
        
        int answer = 1;
        
        for(Entry<String, Integer> entry: map.entrySet()) {
            answer *= entry.getValue()+1;
        }
        
        answer = answer - 1;

        return answer;
    }
}
