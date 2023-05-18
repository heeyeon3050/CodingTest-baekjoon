package org.example.gold4.test14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visit;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visit[i][j] = true;
                dfs(1, arr[i][j], i , j);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public static void dfs(int L, int sum, int x, int y){
        if(L == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx < n && ny >=0 && ny < m && !visit[nx][ny]){
                visit[nx][ny] = true;
                dfs(L+1, sum + arr[nx][ny], nx, ny);
                visit[nx][ny] = false;

                if(L == 2){
                    visit[nx][ny] = true;
                    dfs(L+1, sum + arr[nx][ny], x, y);
                    visit[nx][ny] = false;
                }
            }
        }
    }
}