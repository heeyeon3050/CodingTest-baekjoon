package org.example.silver1.test10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static long mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][10];

        for(int i=1; i<=9; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++) {
                if(j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                }
                // j=9라면 이전 자릿수는 8만 가능
                else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                }
                // 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long sum = 0;
        for(int i=0; i<=9; i++){
            sum += dp[n][i];
        }
        System.out.println(sum % 1_000_000_000);
    }
}
