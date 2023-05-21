package org.example.gold5.test7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int map[][];
    static boolean visit[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int cnt = 0;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        bfs();

        int max = -2;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==0) {
                    System.out.println(-1);
                    return;
                }
                else
                    max = Math.max(max, map[i][j]);
            }
        }
        if(max == 1)
            System.out.println(0);
        else
            System.out.println(max-1);
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX>=0 && nextY>=0 && nextX<N && nextY<M) {
                    if(map[nextX][nextY]==0 || map[nextX][nextY] > map[nowX][nowY]+1) {
                        map[nextX][nextY] = map[nowX][nowY]+1;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
    }
}
