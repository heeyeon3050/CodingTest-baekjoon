package org.example.gold4.test1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static List<Integer>[] list;
    static int[] visit;
    static int v, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int c = Integer.parseInt(br.readLine());

        for(int t=0; t<c; t++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            list = new List[v+1];
            visit = new int[v+1];

            for(int i=0; i<=v; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }
            bfs();
        }

        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= v; i++) {
            if(visit[i] == 0) {
                q.add(i);
                visit[i] = 1;
            }

            while(!q.isEmpty()) {
                int now = q.poll();

                for(int j = 0; j < list[now].size(); j++) {
                    int x = list[now].get(j);

                    if(visit[x] == visit[now]) {
                        sb.append("NO" + "\n");
                        return;
                    }

                    if(visit[x] == 0){
                        q.add(x);
                        if(visit[now] == 1)
                            visit[x] = 2;
                        else
                            visit[x] = 1;
                    }
                }
            }
        }
        sb.append("YES" + "\n");
    }
}
