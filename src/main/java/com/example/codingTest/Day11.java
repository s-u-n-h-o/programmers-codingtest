package com.example.codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day11 {

    //1.알파벳 대소문자로만 이루어진 문자열 my_string이 주어질 때,
    // my_string에서 'A'의 개수, my_string에서 'B'의 개수,...,
    // my_string에서 'Z'의 개수, my_string에서 'a'의 개수,
    // my_string에서 'b'의 개수,..., my_string에서 'z'의 개수를 순서대로 담은 길이 52의 정수 배열을 return 하는 solution 함수를 작성해 주세요.
    public int[] day11_1(String my_string) {
        int[] answer = {};
        String[] str = my_string.split("");
        //대소문자 이루어졌을때(대문자 -> 소문자)
        //아스키 코드
        for(int i = 0 ; i < 52 ; i++) { //배열 돌리기
            for(int j = 65; i < 65 + 26 ; i++) {

            }
        }
        return answer;
    }

    //2.정수 n과 k가 주어졌을 때, 1 이상 n이하의 정수 중에서 k의 배수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
    public int[] day11_2(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i <= n ; i++) {
            if(i % k == 0) {
               list.add(i);
            }
        }
        return list.stream().mapToInt(i->i).toArray();

        //다른풀이
        //나는 int[] count = {}; 일때 배수가 몇개인지 알수가 없으니까 조건을 생각하기 어려운거 같아서 list로 받았는데
        /* count 개수를 구할때 count = n / k 를 하면 o만 있도록 확인하니까 배수임을 확인할수 있고 배열의 크기를 확인할수있다!  */
        // 그리고 for문을 돌때 바로 배수를 구해서 넣으면된다.
        // for (int i = 1; i <= count; i++) {
        //            answer[i - 1] = k * i;
        //        }
    }

    //3.문자열 my_string과 정수 배열 indices가 주어질 때,
    // my_string에서 indices의 원소에 해당하는 인덱스의 글자를 지우고 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
    public String day11_3(String my_string, int[] indices) {
        String answer = "";
        String[] str = my_string.split("");

        for(int i = 0; i < indices.length ; i++) {
            //index에 넣고 해당 인덱스의 인수 삭제 필요
            str[indices[i]] = "";
        }
        answer = String.join("", str);
        return answer;
    }

    //4.정수 start_num와 end_num가 주어질 때,
    //start_num에서 end_num까지 1씩 감소하는 수들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
    public int[] day11_4(int start, int end_num) {
        int[] answer = new int[(start - end_num) + 1];

        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = start;
            start--;
        }
        return answer;
    }

    //5.정수 배열 arr가 주어집니다. 이때 arr의 원소는 1 또는 0입니다.
    // 정수 idx가 주어졌을 때, idx보다 크면서 배열의 값이 1인 가장 작은 인덱스를 찾아서 반환하는 solution 함수를 완성해 주세요.
    //단, 만약 그러한 인덱스가 없다면 -1을 반환합니다.
    public int day11_5(int[] arr, int idx) {
        int answer = -1;
        for(int i = idx; i < arr.length ; i++) {
            if(arr[i] == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
