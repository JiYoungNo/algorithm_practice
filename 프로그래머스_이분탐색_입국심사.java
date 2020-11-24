import java.util.Arrays;
class Solution {
    
    public long solution(int n, int[] times) {

        //먼저 배열을 정렬 -> 심사속도가 가장 빠른 순서 부터 순차적으로 확인하기 위해서
        Arrays.sort(times);

        //최소 소요시간
        long minTime = 1;
        //최대 소요시간 (심사속도가 가장 느린 사람의 속도) X (심사대기 인원수)
        long maxTime = (long) times[times.length-1]*n;

        //중간 값을 계산 할 변수
        long midTime=0;

        //응답 값을 담을 변수 -> 초기 값은 가장 큰 값으로 세팅
        long answer = maxTime;

        //두 값이 일치하는 시점 까지 검사를 해줌
        while(minTime <= maxTime) {

            //중간 값 계산
            midTime = (minTime+maxTime)/2;

            System.out.println("minTime: "+minTime+", maxTime: "+ maxTime+", midTime: "+midTime+", answer: "+answer);

            //기대하는 전체 능률이 실제 능률보다 크거나 같은 경우
            if(totalJudgedPerson(times, midTime) >= n){

                //만약 최소값이 응답 값보다 작은 경우에는
                if( midTime < answer){
                    //중간 값을 응답 값으로 세팅해 줍니다.
                    answer = midTime;
                }
                //그리고 중간 값보다 작은 값을 맥스 값으로 세팅 해줍니다.
                maxTime = midTime-1;
                
            //기대하는 전체 능률이 실제 능률보다 작은 경우
            } else{
                //최소 값에 중간 값보다 큰 값을 넣어줍니다.
                minTime = midTime+1;
            }
        }
        return answer;
    }
    
    //기대 시간에 각각 심사위원이 심사할 수 있는 인원수를 구해 모두 더한 값을 리턴해주는 함수
    public static long totalJudgedPerson(int[] times, long targetTime) {
        long sum = 0;
        for(int time:times){
            sum += targetTime/time;a
        }
        return sum;
    }

}

/** 

<제한사항>
-입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다. (1, 10^9)
-각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다. (1, 10^9)
-심사관은 1명 이상 100,000명 이하입니다. (1, 10^5)
-> 이분탐색 시간 복잡도 O(logN)

<테스트 케이스 출력문>
#####################################################
minTime: 1, maxTime: 60, midTime: 30, answer: 60
minTime: 1, maxTime: 29, midTime: 15, answer: 30
minTime: 16, maxTime: 29, midTime: 22, answer: 30
minTime: 23, maxTime: 29, midTime: 26, answer: 30
minTime: 27, maxTime: 29, midTime: 28, answer: 30
minTime: 27, maxTime: 27, midTime: 27, answer: 28

FFF: minTime: 28, maxTime: 27, midTime: 27, answer: 28
######################################################
*/
