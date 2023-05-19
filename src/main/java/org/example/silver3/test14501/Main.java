package org.example.silver3.test14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] t;
    static int[] p;
    static int n;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        t = new int[n+1];
        p = new int[n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);
        System.out.println(max);
    }

    public static void dfs(int L, int sum){
        if(L > n){
            max = Math.max(max, sum);
            return;
        }

        if(L + t[L] <= n+1)
            dfs(L+t[L], sum + p[L]);

        if(L+1 <= n+1)
            dfs(L+1, sum);
    }
}
