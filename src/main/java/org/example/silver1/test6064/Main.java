package org.example.silver1.test6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int c = Integer.parseInt(br.readLine());
        for(int t=1; t<=c; t++){
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[4];
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = M * N / gcd(M, N);
            // x를 먼저 맞춘다.
            int year = x;
            while(true){
                if(year > lcm){
                    sb.append("-1" + "\n");
                    break;
                }

                else if(((year % N == 0) ? N : year % N) == y){
                    sb.append(year + "\n");
                    break;
                }

                year += M;
            }

        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}
