package com.example.codingTest;

import java.util.Scanner;


public class Day2 {

    //1. 두 정수 a, b가 주어질 때 다음과 같은 형태의 계산식을 출력하는 코드를 작성해 보세요.
    public Integer day2_1() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        return a+b;
    }

    //2. 두 개의 문자열 str1, str2가 공백으로 구분되어 입력으로 주어집니다.
    //입출력 예와 같이 str1과 str2을 이어서 출력하는 코드를 작성해 보세요.
    public String day2_2() {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        String str = (a + b).trim();
        return str;
    }

    //3. 문자열 str이 주어집니다.
    //문자열을 시계방향으로 90도 돌려서 아래 입출력 예와 같이 출력하는 코드를 작성해 보세요.
    public String day2_3() {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] charArr = a.toCharArray();
        String strArr = "";
        for (char c: charArr) {
             strArr += c + "\n";
        }
        return strArr;
    }

    //4.자연수 n이 입력으로 주어졌을 때 만약 n이 짝수이면 "n is even"을, 홀수이면 "n is odd"를 출력하는 코드를 작성해 보세요.
    public String day2_4() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if((n%2) == 0) {
            return n + " is even";
        }else {
            return n + " is odd";
        }
    }

    //5. 문자열 my_string, overwrite_string과 정수 s가 주어집니다.
    //문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을 문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.
    public String day2_5(String my_string, String overwrite_string, int s) {
        String answer = "";
        int overwriteLen = overwrite_string.length();
        answer += my_string.substring(0,s) + overwrite_string + my_string.substring((s+overwriteLen),my_string.length());
        return answer;
    }
}
