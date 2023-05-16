package org.example.silver1.test2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        map[0][0] = 0;
        int answer = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Point now = queue.poll();
                for(int j=0; j<4; j++){
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if(nx == n-1 && ny == m-1){
                        System.out.println(answer+1);
                        System.exit(0);
                    }

                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny]==1){
                        map[nx][ny] = 0;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            answer++;
        }
    }
}
