package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class password17219 {

    /***
     * BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) : InputStreamReader를 입력받아 문자열을 출력해줍니다.
     *                                                                              \n이 입력되기 직전까지 받은 모든 텍스트를 저장
     * StringTokenizer st = new StringTokenizer(br.readLine()); : 문자열을 특정 구분자(예: 공백, 쉼표)로 분리하는 클래스로 기본적으로 공백 구분자로
     *                                                            사용하지만 직접 지정할수 있다.
     * StringBuilder sb = new StringBuilder(); : 문자열을 동적으로 수정할때 사용하는 클래스이다.
     *                                           String은 불변객체라서 새롭게 객체가 생성되지만 StringBuilder사용시 기존문자열을 변경하는 방식
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); //사이트 주소 수
        int m = Integer.parseInt(st.nextToken()); //비밀번호를 찾아야하는 사이트 주소 수

        HashMap<String,String> hashMap = new HashMap<>();
        for(int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            hashMap.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            sb.append(hashMap.get(br.readLine())+ "\n");
        }
        System.out.print(sb);
    }
}