package com.example.codingTest_basic;

public class Day10 {

    //1.문자열 my_string과 정수 n이 매개변수로 주어질 때,
    // my_string의 앞의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.
    public String day10_1(String my_string, int n) {
        String answer = "";
        String[] str = my_string.split("");

        for(int i = 0; i < n ;i++) {
            answer += str[i];
        }
        return answer;

        //다른 풀이
        //그냥 바로 n만큼 자르면 되는데 왜 for문을 돌렸을까
        //return  my_string.substring(0,n);
    }

    //2. 어떤 문자열에 대해서 접두사는 특정 인덱스까지의 문자열을 의미합니다.
    //예를 들어, "banana"의 모든 접두사는 "b", "ba", "ban", "bana", "banan", "banana"입니다.
    //문자열 my_string과 is_prefix가 주어질 때, is_prefix가 my_string의 접두사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.
    public int day10_2(String my_string, String is_prefix) {
        int answer = 0;
        String[] prefix_str = new String[my_string.length()];
        int count = 0;
        for(int i = 0 ; i < prefix_str.length ; i++) {
            prefix_str[i] = my_string.substring(0,i);
            if(prefix_str[i].equals(is_prefix)) {
                answer = 1;
            }
        }
        return answer;

        //다른풀이
        /* 여기서도 지금 startwith을 사용하여 비교대상 문자열이 입력된 문자열값으로 시작되는지 여부를 확인할수있다.*/
        //if (my_string.startsWith(is_prefix)) return 1;
    }

    //3.문자열 my_string과 정수 s, e가 매개변수로 주어질 때,
    // my_string에서 인덱스 s부터 인덱스 e까지를 뒤집은 문자열을 return 하는 solution 함수를 작성해 주세요.
    public String day10_3(String my_string, int s, int e) {

        String answer = "";
        String originStr = "";
        String reserveStr = "";
        for (int i = s ; i < e-s+1; i++) {
            originStr = String.valueOf(my_string.charAt(i));
            StringBuffer sb = new StringBuffer(originStr);
            reserveStr = String.valueOf(sb.reverse());

            //1차 시도 -> 테스트할때는 통과하는데 어딘가에서 오류가 나는것같다. 정답제출시 런타임 오류가 발생
//        String[] strArr = my_string.split("");
//        String temp = "";
//        for(int i = 0 ; i < e-s+1 ; i++) {
//            temp = strArr[s];
//            strArr[s] = strArr[e];
//            strArr[e] = temp;
//            e--;
//            s++;
//        }
//        answer = String.join("",strArr);
        }
        return answer = my_string.replaceAll(originStr, reserveStr);
    }
    //4.문자열 my_string과 두 정수 m, c가 주어집니다.
    // my_string을 한 줄에 m 글자씩 가로로 적었을 때 왼쪽부터 세로로 c번째 열에 적힌 글자들을 문자열로 return 하는 solution 함수를 작성해 주세요.
    public String day10_4(String my_string, int m, int c) {
        String answer = "";
        int len = (my_string.length() / m);
        String[] rowStr = new String[len];
        String str = "";
        int st_idx = 0;
        for(int i = 0 ; i < len ; i++) {
            rowStr[i] = my_string.substring(st_idx, m + st_idx);
            str = rowStr[i].substring(c-1, c);
            answer += str;

            st_idx += m;
        }
        return answer;
    }

    //5.두 정수 q, r과 문자열 code가 주어질 때,
    // code의 각 인덱스를 q로 나누었을 때 나머지가 r인 위치의 문자를 앞에서부터 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
    public String day10_5(int q, int r, String code) {
        String answer = "";
        int len = code.length();
        for(int i = 0 ; i < len ; i++) {
            if((i % q) == r) {
                answer += code.charAt(i);
            }
        }
        return answer;
    }
}
