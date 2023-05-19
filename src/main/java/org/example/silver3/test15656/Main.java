package org.example.silver3.test15656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, new int[m]);

        System.out.println(sb);
    }

    public static void dfs(int L, int[] num){
        if(L == m) {
            for(int i=0; i<m; i++){
                sb.append(num[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            num[L] = arr[i];
            dfs(L+1, num);
        }
    }
}
