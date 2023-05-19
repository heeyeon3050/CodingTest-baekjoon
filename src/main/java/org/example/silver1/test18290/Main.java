package org.example.silver1.test18290;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0,-1};
    static int[][] arr;
    static boolean[][] visit;
    static int n, m, k;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+2][m+2];
        visit = new boolean[n+2][m+2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int L, int sum){
        if(L == k){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visit[i][j]){
                    if(check(i, j)){
                        visit[i][j] = true;
                        dfs(L+1, sum + arr[i][j]);
                        visit[i][j] = false;
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y){
        boolean flag = true;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (visit[nx][ny]) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }
}
