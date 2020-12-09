import java.util.LinkedList;
import java.util.Queue;

class Node {
    String next;
    int edge;
    
    public Node(String next, int edge) {
        this.next = next;
        this.edge = edge;
    } 
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visit = new boolean[words.length];
        
        Queue<Node> q = new LinkedList<>();   
        q.offer(new Node(begin,0));
        
        while(!q.isEmpty()) {
            System.out.println(q);
            Node val = q.poll();
            
            if(val.next.equals(target)) {
                answer = val.edge;
                break;
            }
            
            for(int i=0; i<words.length; i++) {
                if(!visit[i] && isNext(val.next, words[i])) {
                    visit[i] = true;
                    q.offer(new Node(words[i], val.edge + 1));
                }
            }
        }    
        return answer;
    }
    
    private boolean isNext(String value , String n) {
        int count = 0;
        for(int i=0; i< n.length() ; i++) {
            if(value.charAt(i) != n.charAt(i)) {
                if(++count > 1) return false; 
            }
        }
        return true;
    }
}
