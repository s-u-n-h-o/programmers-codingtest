package com.example.codingTest_basic;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class Day3 {

    //1. 길이가 같은 두 문자열 str1과 str2가 주어집니다.
    //두 문자열의 각 문자가 앞에서부터 서로 번갈아가면서 한 번씩 등장하는 문자열을 만들어 return 하는 solution 함수를 완성해 주세요.
    public String day3_1(String str1, String str2) {
        String answer = "";
        int i = 1;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int len = str1.length() + str2.length(); //총길이
        int char1Idx = 0;
        int char2Idx = 0;

        while (i <= len) {

            if(i % 2 == 0) {
                answer += String.valueOf(chars2[char2Idx]);
                char2Idx++;
            }else {
                answer += String.valueOf(chars1[char1Idx]);
                char1Idx++;
            }
            i++;
        }
        return answer;
    }
    //2. 문자들이 담겨있는 배열 arr가 주어집니다. arr의 원소들을 순서대로 이어 붙인 문자열을 return 하는 solution함수를 작성해 주세요.
    public String day3_2(String[] arr) {
        String answer = "";
        for (String s : arr) {
            answer += s;
        }
        return answer;
    }

    //3. 문자열 my_string과 정수 k가 주어질 때, my_string을 k번 반복한 문자열을 return 하는 solution 함수를 작성해 주세요.
    public String day3_3(String my_string, int k) {
        String answer = "";
        int i = 0;
        while (i < k) {
         answer += my_string;
         i++;
        }
        return answer;
        //다른 사람 풀이 중 repeat메소드 사용시 한줄로 사용가능
        //answer += my_string.repeat(k);
    }

    //4. 연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
    //12 ⊕ 3 = 123
    //3 ⊕ 12 = 312
    //양의 정수 a와 b가 주어졌을 때, a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.
    //단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.
    public int day3_4(int a, int b) {
        int answer = 0;
        int prePlus = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int backPlus = Integer.parseInt(String.valueOf(b) + String.valueOf(a));

        if(prePlus > backPlus) {
            answer = prePlus;
        }else if(prePlus < backPlus) {
            answer = backPlus;
        }else {
            answer = prePlus;
        }
        return answer;

        //다른사람 풀이
        //Math 클래스 메소드를 사용하면 빠르게 계산할수 있다.
        // ex)
        // - pow() : 제곱연산 실행 Math.pow(5,2) = 25
        // - sqrt() : 제곱근값 반환 Math.sqrt(25) = 5
        //Math.max(Integer.valueOf(prePlus), Integer.valueOf(backPlus));
    }

    //5. 연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
    //12 ⊕ 3 = 123
    //3 ⊕ 12 = 312
    //양의 정수 a와 b가 주어졌을 때, a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.
    //단, a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다.
    public int day3_5(int a, int b) {
        int intToStr1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int intToStr2 = 2 * a * b;

        return max(intToStr1, intToStr2);
    }
}
