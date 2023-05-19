package org.example.silver3.test15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n+1];

        dfs(0, arr, 1);
        System.out.println(sb);
    }

    public static void dfs(int L, int[] arr, int start){
        if(L == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=n; i++) {
            arr[L] = i;
            dfs(L + 1, arr, i);
        }
    }
}
