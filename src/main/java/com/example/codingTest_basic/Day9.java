package com.example.codingTest_basic;

import java.util.*;

public class Day9 {

    //1.문자열 배열 intStrs와 정수 k, s, l가 주어집니다. intStrs의 원소는 숫자로 이루어져 있습니다.
    //배열 intStrs의 각 원소마다 s번 인덱스에서 시작하는 길이 l짜리 부분 문자열을 잘라내 정수로 변환합니다.
    // 이때 변환한 정수값이 k보다 큰 값들을 담은 배열을 return 하는 solution 함수를 완성해 주세요.
    public int[] day9_1(String[] intStrs, int k, int s, int l) {
        int num = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < intStrs.length; i++) {
            num = Integer.parseInt(intStrs[i].substring(s, s+l));
            if(num > k) {
             list.add(num);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    //2.길이가 같은 문자열 배열 my_strings와 이차원 정수 배열 parts가 매개변수로 주어집니다.
    // parts[i]는 [s, e] 형태로, my_string[i]의 인덱스 s부터 인덱스 e까지의 부분 문자열을 의미합니다.
    // 각 my_strings의 원소의 parts에 해당하는 부분 문자열을 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
    public String day9_2(String[] my_strings, int[][] parts) {
        String answer = "";
        List<String> strList = new ArrayList<>();
        for(int i = 0; i < my_strings.length ; i++) {
            int st_idx = parts[i][0];
            int ed_idx = parts[i][1];
            strList.add(my_strings[i].substring(st_idx, ed_idx+1));
        }

        for(String str : strList) {
            answer += str;
        }
        return answer;
    }

    //3.문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string의 뒤의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.
    public String day9_3(String my_string, int n) {
        String answer = my_string.substring(my_string.length() - n);
        return answer;
    }

    //4.어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다.
    // 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
    //문자열 my_string이 매개변수로 주어질 때, my_string의 모든 접미사를 사전순으로 정렬한 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
    public String[] day9_4(String my_string) {
        String[] answer = new String[my_string.length()];

        for(int i = 0 ; i < my_string.length() ; i++) {
            answer[i] = my_string.substring(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    //5.어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다.
    //예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
    //문자열 my_string과 is_suffix가 주어질 때, is_suffix가 my_string의 접미사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.
    public int day9_5(String my_string, String is_suffix) {
        int answer = 0;
        Map<String, Integer> map = new HashMap();

        for(int i = 0; i < my_string.length() ; i++) {
            map.put(my_string.substring(i), 1);
        }

        if(map.containsKey(is_suffix)) {
            answer = 1;
        }else {
            answer = 0;
        }
        return answer;

        //다른사람풀이
        /* 금방 풀었는데, 알고보니 이렇게 푸는건 비효율적이였다. 아래와 같이 메소드가 있었다.

        *  startsWith() : String이 특정 문자열로 시작하는지를 boolean 타입으로 리턴해줍니다.
        *  endsWith() : 특정 문자열로 끝나는지 boolean 타입으로 리턴해줍니다.
                if(my_string.endsWith(is_suffix)) {
                    return 1;
                } else {
                    return 0;
                }
        *
        *
        * */
    }
}
