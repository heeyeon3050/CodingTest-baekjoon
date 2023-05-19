package org.example.silver3.test15649;

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

        dfs(0, arr);
        System.out.println(sb);
    }

    public static void dfs(int L, int[] arr){
        if(L == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[L] = i;
                dfs(L + 1, arr);
                visit[i] = false;
            }
        }
    }
}