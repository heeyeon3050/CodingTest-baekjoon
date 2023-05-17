package org.example.silver2.test3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int max = Integer.MIN_VALUE;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                char temp = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = temp;

                check(arr);

                temp = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = temp;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                char temp = arr[j][i];
                arr[j][i] = arr[j+1][i];
                arr[j+1][i] = temp;

                check(arr);

                temp = arr[j][i];
                arr[j][i] = arr[j+1][i];
                arr[j+1][i] = temp;
            }
        }

        System.out.println(max);
    }

    public static void check(char[][] arr){
        for(int i=0; i<n; i++){
            int cnt = 1;
            for(int j=0; j<n-1; j++){
                if(arr[i][j] == arr[i][j+1]){
                    cnt++;
                }
                else
                    cnt = 1;
                max = Math.max(max, cnt);
            }
        }

        for(int i=0; i<n; i++){
            int cnt = 1;
            for(int j=0; j<n-1; j++){
                if(arr[j][i] == arr[j+1][i]){
                    cnt++;
                }
                else
                    cnt = 1;
                max = Math.max(max, cnt);
            }
        }
    }
}
