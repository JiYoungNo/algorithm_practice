import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> g1 = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            g1.put(genres[i], g1.getOrDefault(genres[i], 0) + plays[i]);
        }

        TreeMap<Integer, String> g2 = new TreeMap<>(Collections.reverseOrder());

        g1.forEach((k, v) -> g2.put(v, k));

        ArrayList<Integer> answer2 = new ArrayList<>();
        
        for (var genre : g2.values()) {
            ArrayList<Integer> temp = new ArrayList<>();    
            for (int i = 0; i < genres.length; i++) {
                if (!genres[i].equals(genre)) continue;

                temp.add(i);
            }

            Collections.sort(temp, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (plays[o1] == plays[o2]) {
                        return Integer.compare(o1, o2);
                    }
                    else {
                        return Integer.compare(plays[o2], plays[o1]);
                    }
                }
            });
            answer2.add(temp.get(0));
            if (temp.size() > 1) {
                answer2.add(temp.get(1));
            }
        }

        int[] answer = new int[answer2.size()];
        for (int i = 0; i < answer2.size(); i++) {
            answer[i] = answer2.get(i);
        }

        return answer;
    }
}
