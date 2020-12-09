class Solution {
    public int solution(int[] numbers, int target) {
        return DFS(numbers, target, 0, 0);
    }
    
    private int DFS(int[] numbers, int target, int index, int value) {
        
        if(numbers.length == index) {
            int result = 0;
            if(value == target) 
                result = 1;
            
            return result;
        } else {
            return DFS(numbers, target, index+1, value+numbers[index])
                + DFS(numbers, target, index+1, value-numbers[index]);
        }
        
    }
}
