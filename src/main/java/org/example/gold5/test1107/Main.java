package org.example.gold5.test1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int target = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];

        if(m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int n = Integer.parseInt(st.nextToken());
                broken[n] = true;
            }
        }

        int result = Math.abs(target - 100); //처음 시작 번호가 100이므로 100에서 target까지 갈 수 있는 최대값으로 설정
        for(int i = 0; i <=999999; i++) { //target은 최대 500000이어도 999999에서 조절하는 게 더 빠를 경우가 있으므로
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) { //고장난 버튼이면 패스
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak) {
                int min = Math.abs(target - i) + len; //현재 번호에서 target까지 눌러야하는 횟수 + 해당 번호의 길이(하나하나씩 눌러야하므로)
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}