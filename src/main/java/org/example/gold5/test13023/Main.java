package org.example.gold5.test13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        visit = new boolean[n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0; i<n; i++) {
            visit = new boolean[n];
            visit[i] = true;
            dfs(0, i);
        }

        System.out.println(0);
    }

    public static void dfs(int L, int a){
        if(L == 4){
            System.out.println(1);
            System.exit(0);
        }

        for(int x : list[a]) {
            if(!visit[x]) {
                visit[x] = true;
                dfs(L + 1, x);
                visit[x] = false;
            }
        }
    }
}
