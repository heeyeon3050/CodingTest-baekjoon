package org.example.silver1.test15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visit;
    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        visit = new boolean[n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n/2; i++){
            dfs(0, i, 1);
        }

        System.out.println(min);
    }

    public static void dfs(int L, int num, int start){
        if(L == num){
            diff();
            return;
        }

        for(int i=start; i<=n; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(L+1, num, i);
                visit[i] = false;
            }
        }
    }

    public static void diff(){
        int team_start = 0;
        int team_link = 0;

        for(int i=1; i<=n-1; i++){
            for(int j=i+1; j<=n; j++){
                if(visit[i] && visit[j]){
                    team_start += arr[i][j];
                    team_start += arr[j][i];
                }

                if(!visit[i] && !visit[j]){
                    team_link += arr[i][j];
                    team_link += arr[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(team_start-team_link));

        if(min == 0){
            System.out.println(0);
            System.exit(0);
        }
    }
}
