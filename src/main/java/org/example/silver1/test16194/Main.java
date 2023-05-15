package org.example.silver1.test16194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] price = new int[n+1];
        int[] dp = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            dp[i] = price[i];
            for(int j=1; j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j]+price[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
