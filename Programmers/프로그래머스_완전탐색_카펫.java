import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 두 사이즈를 먼저 계산한다.
        int[] size = {0, 0};

        //노란 부분을 기준으로 루프를 돈다
        for(int i=1; i<=yellow/2+1; i++) {

            size[0] = i;
            
            //약수이면 나누기 한 값, 약수가 아니면 나누기한 값 + 1
            size[1] = (yellow%i == 0) ? yellow/i : yellow/i+1;

            //2씩 곱하고 + 4(모서리) 가 브라운과 같으면 루프종료
            if((2*size[0] + 2*size[1] + 4) == brown)
                break;
        }

        //정렬 -> 최대 최소 때문
        Arrays.sort(size);

        //응답에는 큰값+2(브라운), 작은 값+2(옐로우)
        int[] answer = {size[1]+2, size[0]+2};

        return answer;
    }
}
