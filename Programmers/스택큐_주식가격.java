
/*
이중 포문을 사용한 풀이
시간복잡도는 @(n^2)
범위 10만 최악의 경우 100억..

*/
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				answer[i]++;
				if (prices[i] > prices[j]) 
					break;
				
			}
		}
        
        return answer;
    
    }
}

//스택이용한 코드
//peek 읽기만 pop 데이터도 뽑아냄

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
  
		Stack<Integer> stack = new Stack();

		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				answer[stack.peek()] = i - stack.peek();
				stack.pop(); 
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) { 
			answer[stack.peek()] = prices.length - stack.peek() - 1;
			stack.pop();
		}

		return answer;
    
    }
}
