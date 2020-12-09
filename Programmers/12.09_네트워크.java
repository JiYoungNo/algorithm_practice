import java.util.*;

class Solution {
    
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0; i< n; i++) {
            
            if(!visited[i]) {
                BFS(n, i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    void BFS(int n, int node, int[][] computers) {
        //System.out.println("n: "+n+", node: "+node+", visit: ");
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        
        while(!q.isEmpty()) {
            int tmp = q.poll();
            visited[tmp] = true;
                        
            for(int i=0; i<n; i++) {
                if(computers[tmp][i] == 1 && !visited[i]) {
                    q.offer(i);
                }
            }
        }
    }
}
