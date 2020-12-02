import java.util.HashMap;

class Solution {
        public boolean solution(String[] phone_book) {
            
        boolean answer = true;
        HashMap<String, Integer> checkMap = new HashMap<String, Integer>();
        for(String value : phone_book) {
            for(int i = 1; i < value.length(); i++) {
            	checkMap.put(value.substring(0, i), 1);
            }
        }
            
        for(String value : phone_book) {
            if(checkMap.containsKey(value)) {
                answer = false;
                break;
            } 
        }
            
        return answer;
    }
}
