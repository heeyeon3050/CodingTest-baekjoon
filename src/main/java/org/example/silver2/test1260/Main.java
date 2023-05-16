package org.example.silver2.test1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0; i<=n; i++){
            Collections.sort(list[i]);
        }

        visit = new boolean[n+1];
        visit[v] = true;
        dfs(v);

        sb.append("\n");
        visit = new boolean[n+1];
        visit[v] = true;
        bfs(v);

        System.out.println(sb);
    }

    public static void bfs(int a){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        sb.append(a + " ");

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int x : list[now]){
                if(!visit[x]) {
                    visit[x] = true;
                    sb.append(x + " ");
                    queue.offer(x);
                }
            }
        }
    }

    public static void dfs(int a){
        sb.append(a + " ");
        for(int x : list[a]){
            if(!visit[x]) {
                visit[x] = true;
                dfs(x);
            }
        }
    }
}
