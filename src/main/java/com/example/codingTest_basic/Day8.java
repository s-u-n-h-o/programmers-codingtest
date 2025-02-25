package com.example.codingTest_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 {
    //1. boolean 변수 x1, x2, x3, x4가 매개변수로 주어질 때, 다음의 식의 true/false를 return 하는 solution 함수를 작성해 주세요.
    //(x1 ∨ x2) ∧ (x3 ∨ x4)
    public boolean day8_1(boolean x1, boolean x2, boolean x3, boolean x4) {
        //1. 논리곱(and (∧)) : 모든값이 참(true)인경우 참 / 나머지는 거짓
        //2. 논리합(or (∨)) : 모든값이 거짓(false)인 경우 거짓 / 나머지는 참
        boolean answer = (x1 || x2) && (x3 || x4);

        return answer;
    }

    //2.1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다. 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.
    //네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
    //세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
    //주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
    //어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
    //네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
    //네 주사위를 굴렸을 때 나온 숫자가 정수 매개변수 a, b, c, d로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
    public int day8_2(int a, int b, int c, int d) {
        int answer = 0;
        int[] nums = {a,b,c,d};
        int count = 0;
        List<Integer> sameList = new ArrayList<>();
        List<Integer> diffList = new ArrayList<>();

        //크게 3번 돌아야함
        for(int i = 0; i < 3 ; i++) {
            for(int j = i+1; j <= 3 ; j++) {
                if(nums[i] == nums[j]) {
                    sameList.add(nums[j]);
                    count++;
                }else {
                    diffList.add(nums[j]);
                }
            }
        }
        sameList = sameList.stream().distinct().collect(Collectors.toList()); //중복제거
        diffList = diffList.stream().distinct().collect(Collectors.toList()); //중복제거
        diffList.removeAll(sameList);

        //카운트 수마다 값계산 다르도록 하기 위해서
        switch (count) {
            case 6 : answer = a * 1111; break;
            case 3 : answer = (10 * sameList.get(0) + diffList.get(0)) * (10 * sameList.get(0) + diffList.get(0)); break;
            case 2 : answer = (sameList.get(0) + sameList.get(1)) * (Math.abs(sameList.get(0) - sameList.get(1))); break;
            case 1 : answer = (diffList.get(0) * diffList.get(1)); break;
            case 0 : answer = Arrays.stream(nums).min().getAsInt(); break;
        }
        return answer;
    }

    //3.문자열 my_string과 정수 배열 index_list가 매개변수로 주어집니다.
    // my_string의 index_list의 원소들에 해당하는 인덱스의 글자들을 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
    public String day8_3(String my_string, int[] index_list) {
        String answer = "";
        char[] arr = my_string.toCharArray();

        for(int i = 0 ; i < index_list.length ; i++) {
            answer += arr[index_list[i]];
        }
        return answer;
    }

    //4. 음이 아닌 정수를 9로 나눈 나머지는 그 정수의 각 자리 숫자의 합을 9로 나눈 나머지와 같은 것이 알려져 있습니다.
    //이 사실을 이용하여 음이 아닌 정수가 문자열 number로 주어질 때, 이 정수를 9로 나눈 나머지를 return 하는 solution 함수를 작성해주세요.
    public int day8_4(String number) {
        //-> 문제만 읽어도 어떤 의도인지 말해주고있는데 왜 어렵게 생각해서 풀었을까 (key point : 그 정수의 각 자리 숫자의 합을 9로 나눈 나머지와 같다)
        int answer = 0;
        int sum = 0;
        String[] numList = number.split("");

        for(String n : numList) {
            sum+=Integer.parseInt(n);
        }
        answer = sum % 9;
        return answer;
    }

    //5. 문자열 my_string과 이차원 정수 배열 queries가 매개변수로 주어집니다.
    // queries의 원소는 [s, e] 형태로, my_string의 인덱스 s부터 인덱스 e까지를 뒤집으라는 의미입니다.
    // my_string에 queries의 명령을 순서대로 처리한 후의 문자열을 return 하는 solution 함수를 작성해 주세요.
    public String day8_5(String my_string, int[][] queries) {
        String answer = ""; //return 값
        String[] strArr = my_string.split(""); //String -> 배열로 변경

        for(int i = 0 ; i < queries.length; i++) {
            int st_idx = queries[i][0]; //시작
            int ed_idx = queries[i][1]; //끝
            for(int j = st_idx ; j < ed_idx; j++) {
                String temp = strArr[st_idx];
                strArr[st_idx] = strArr[ed_idx];
                strArr[ed_idx] = temp;
                st_idx++;
                ed_idx--;
            }
        }
        answer = String.join("", strArr);
        return answer;
    }
}