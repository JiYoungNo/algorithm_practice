package January13;

import java.util.Scanner;

public class BJ_2875 {

    public static void main(String[] args) {
        //입력 부분
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int K = scan.nextInt();
        //출력부분
        System.out.println(sol(N, M, K));
    }

    public static int sol(int N, int M, int K) {
        int div = N/2;

        if(div > M)
            div = M;

        while(((M-div) + (N - 2*div)) < K)
            div--;

        return div;
    }
}
