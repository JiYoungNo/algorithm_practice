import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] size = {0, 0};

        for(int i=1; i<=yellow/2+1; i++) {

            size[0] = i;
            size[1] = (yellow%i == 0) ? yellow/i : yellow/i+1;

            if((2*size[0] + 2*size[1] + 4) == brown)
                break;
        }

        Arrays.sort(size);

        int[] answer = {size[1]+2, size[0]+2};

        return answer;
    }
}
