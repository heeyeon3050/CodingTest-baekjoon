package org.example.gold5.test1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] m = {'a', 'e', 'i', 'o', 'u'};
    static StringBuilder sb = new StringBuilder();
    static char[] arr;
    static boolean[] visit;
    static int l, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        visit = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        dfs(0, new char[l], 0);

        System.out.println(sb);
    }

    public static void dfs(int L, char[] answer, int start){
        if(L == l){
            if(check(answer)){
                for(char a : answer)
                    sb.append(a);
                sb.append("\n");
            }
            return;
        }

        for(int i=start; i<c; i++){
            if(!visit[i]){
                visit[i] = true;
                answer[L] = arr[i];
                dfs(L+1, answer, i+1);
                visit[i] = false;
            }
        }
    }

    public static boolean check(char[] arr){
        int cnt = 0;
        for(int i=0; i<l; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i] == m[j]) {
                    cnt++;
                    break;
                }
            }
        }

        if(cnt >=1 && (l-cnt) >= 2){
            return true;
        }
        return false;
    }
}
