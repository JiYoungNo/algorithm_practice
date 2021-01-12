package January13;

import java.util.Scanner;

public class BJ_2193 {

    public static void main(String[] args) {
        //입력 부분
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        //출력 부분
        System.out.println(dp(N));
    }

    public static long dp(int N) {
        long[] dpArr = new long[N+1];

        if(N == 1) return 1;
        if(N == 2) return 1;

        dpArr[1] = 1;
        dpArr[2] = 1;

        for (int i=3; i <= N; i++)
            dpArr[i] = dpArr[i-1] + dpArr[i-2];

        return dpArr[N];
    }
}
