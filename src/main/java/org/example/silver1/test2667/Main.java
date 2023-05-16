package org.example.silver1.test2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int n;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    map[i][j] = 0;
                    cnt = 1;
                    answer++;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }

        sb.append(answer + "\n");
        Collections.sort(list);
        for(int i=0; i<list.size(); i++)
            sb.append(list.get(i) + "\n");
        System.out.println(sb);
    }

    public static void dfs(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >=0 && ny < n && map[nx][ny] == 1){
                map[nx][ny] = 0;
                cnt++;
                dfs(nx, ny);
            }
        }
    }
}
