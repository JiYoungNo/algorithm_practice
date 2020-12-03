import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int value: scoville)
            queue.offer(value);

        while(queue.size() > 1 && queue.peek() < K) {
            int min1 = queue.poll();
            int min2 = queue.poll();
            queue.offer(min1 + min2*2);
            answer++;
        }

        if(queue.size() == 1 && queue.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}

/*
- 스코빌 지수 → 음식 마다 있는 등급 같은 개념.
- 레오는 모든 스코빌 지수를 K보다 크게 만들고 싶어함.

- 스코빌지수를 담고 있는 배열 scoville의 크기 [2,1,000,000]
- K [0, 1,000,000,000]
- scoville 원소 [0, 1,000,000]
- 모든 음식이 불가능한 경우 -1 리턴

- 모든 음식에 스코빌 지수를 높이지 못하는 경우는 마지막에 큐에 1개가 남았는데도 K보다 작은 경우이다.
- 음식이 2개이상 들어오고 2개를 합쳐서 1개를 만드니까 → 한번 연산할 때마다 수가 하나씩 작아짐

*/
