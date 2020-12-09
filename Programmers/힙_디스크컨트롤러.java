import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int jobsSize = jobs.length;
        int currentTime = 0;

        int cnt = 0;
        int jobsIndex = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (cnt < jobsSize) {

            while (jobsIndex < jobsSize && currentTime >= jobs[jobsIndex][0]) {
                pq.offer(jobs[jobsIndex++]);
            }
            
            if(pq.isEmpty()) {
                currentTime = jobs[jobsIndex][0];
            } else {
                int[] data = pq.poll();
                answer += currentTime + data[1] - data[0];
                currentTime += data[1];
                cnt++;
            }
        }
        return (int)Math.floor(answer/jobsSize);
    }
}
