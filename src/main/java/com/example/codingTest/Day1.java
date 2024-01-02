package com.example.codingTest;

import java.util.Scanner;

public class Day1 {

    /* 대소문자 바꿔서 출력하기
    * 영어 알파벳으로 이루어진 문자열 str이 주어집니다.
    * 각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성해 보세요.
    */
    public String lowerAndUpper() {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] charArr = a.toCharArray();
        StringBuilder strArr = new StringBuilder();
        int i = 0;
        for (char c : charArr) {
            String s = String.valueOf(c);
            if (s == s.toUpperCase()) {
                strArr.append(s.toLowerCase());
                i++;
            } else if (s == s.toLowerCase()) {
                strArr.append(s.toUpperCase());
                i++;
            }
        }
        //System.out.println(strArr);
        return strArr.toString();
    }

    /* 특수문자 출력하기
    * 다음과 같이 출력하도록 코드를 작성해 주세요.
    * !@#$%^&*(\'"<>?:;
    * */
    public String convertSpecialCharacters () {
        return "!@#$%^&*(\\'\"<>?:;";
    }
}
