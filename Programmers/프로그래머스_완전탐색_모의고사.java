import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] student_01 = {1, 2, 3, 4, 5};
        int[] student_02 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student_03 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] count = new int[3];

        for(int i=0; i<answers.length; i++) {
            int len_01 = student_01.length;
            int len_02 = student_02.length;
            int len_03 = student_03.length;

            if(answers[i] == student_01[i%len_01]) count[0]++;
            if(answers[i] == student_02[i%len_02]) count[1]++;
            if(answers[i] == student_03[i%len_03]) count[2]++;
        }

        int max = Math.max(count[0], Math.max(count[1], count[2]));

        ArrayList<Integer> countMax = new ArrayList<Integer>();

        if(max == count[0]) countMax.add(1);
        if(max == count[1]) countMax.add(2);
        if(max == count[2]) countMax.add(3);

        return countMax.stream().mapToInt(i->i.intValue()).toArray();
    }
}
