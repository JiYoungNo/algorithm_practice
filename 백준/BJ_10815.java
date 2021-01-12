package January13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BJ_10815 {

    public static void main(String[] args) {

        //입력 부분
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        HashSet<Integer> hashN = new HashSet<>();
        for(int i = 0; i < N; i++)
            hashN.add(scan.nextInt());

        int M = scan.nextInt();
        List<Integer> arrM = new ArrayList<>();
        for(int i = 0; i < M; i++)
            arrM.add(scan.nextInt());

        //출력부분
        arrM.forEach(
                x -> System.out.print(((hashN.contains(x)) ? 1:0) + " ")
        );

    }
}
