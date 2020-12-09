import java.util.*;

class Solution {
    
    List<Node> list = new ArrayList<>();
    boolean[] visit;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        visit = new boolean[n+1];
        int maxLevel =  BFS(n, edge);
        
        for(Node node : list) {
            if(node.level == maxLevel)
                answer++;
        }
        
        return answer;
    }
    
    private int BFS(int n, int[][] edge) {
        
        int maxLevel = 0;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,1));
        
        
        while(!q.isEmpty()) {
            Node value = q.poll();
            list.add(value);
            maxLevel = value.level;
            
            if(!visit[value.node])
                visit[value.node] =true;
            
            for(int[] vertex: edge) {
                
                if(vertex[0] == value.node && !visit[vertex[1]] && !qContains(q,vertex[1])) { 
                    q.offer(new Node(vertex[1], value.level+1));
                } else if(vertex[1] == value.node && !visit[vertex[0]] && !qContains(q,vertex[0])) {
                    q.offer(new Node(vertex[0], value.level+1));
                }
            }
        }
        
        return maxLevel;
    }
    
    public boolean qContains(Queue<Node> q, int node) {
        boolean contain = false;
        
        for(Node nodeObject:  q.toArray(new Node[q.size()])) {
            if(nodeObject.node == node) {
                contain = true;
                break;
            }
        }
        return contain;
    }
}


class Node {
    int node;
    int level;
     
    public Node(int node, int level) {
        this.node = node;
        this.level = level;
    }
}
