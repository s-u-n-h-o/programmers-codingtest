package com.example.codingTest_scoreBooster.sorting;

import java.util.Arrays;

//가장 큰수
public class LargestNumber {

    public String solution(int[] numbers) {
        String answer = "";
        String[] numberStr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numberStr[i] = Integer.toString(numbers[i]);
        }
        //문자열을 비교하는 경우
        // 0: 두 문자열이 같은 경우
        // 음수 : 인자가 객체보다 시간적으로 순서가 앞인 경우
        // 양수 : 객체가 인자보다 사전적으로 순서가 앞인 경우
        /***
         * 두 문자열을 이어붙였을때 더 큰값을 만드는 순서대로 정렬
         * (ex) ["3","30","34","5","9"]
         * 1. "30" vs "3"
         *  - "303" (30+3)
         *  - "330" (3+30)
         *  => 330이 크니까 "3"이 "30"보다 앞에
         *
         * 2. "34" vs "3"
         *  - "343"
         *  - "334"
         *  => 343이 크니까 "34"가 "3"보다 커야함
         *
         * 3. "5" vs "34"
         *  - "534"
         *  - "345"
         *  => 534가 크니까 "5"가 "34"보다 커야함
         *
         * 4. "9" vs "5"
         *  - "95"
         *  - "59"
         *  => 95가 크니까 "9"가 "5"보다 커야함
         *
         *  ==> 최종으로 9,5,34,3,30
         *
         */
        Arrays.sort(numberStr, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        if(numberStr[0].equals("0")) {
            return "0";
        }
        for(String number : numberStr) {
            answer += number;
        }
        return answer;
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        largestNumber.solution(new int[]{3, 30, 34, 5, 9});
    }
}
