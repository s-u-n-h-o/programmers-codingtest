package com.example.codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

public class Day6 {

    //정수 리스트 num_list가 주어질 때, 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을 마지막 원소가 그전 원소보다 크지 않다면
    //마지막 원소를 두 배한 값을 추가하여 return하도록 solution 함수를 완성해주세요.
    public int[] day6_1(int[] num_list) {
        int numLen = num_list.length - 1;
        int lastNum = num_list[numLen];
        int preNum = num_list[numLen - 1];

        int[] answer = Arrays.copyOf(num_list, numLen + 2);

        if(lastNum > preNum) {
            answer[answer.length - 1] = lastNum - preNum;
        }else {
            answer[answer.length - 1] = lastNum * 2;
        }
        return answer;

        //다른사람풀이
        //어렵게 생각했는데 배열을 그냥 한자리 크게 선언한후 코드작성이 더 편리했던 방법 같다.
    }

    //2.정수 n과 문자열 control이 주어집니다. control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며,
    // control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.
    //"w" : n이 1 커집니다.
    //"s" : n이 1 작아집니다.
    //"d" : n이 10 커집니다.
    //"a" : n이 10 작아집니다.
    //위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return 하는 solution 함수를 완성해 주세요.
    public int day6_2(int n, String control) {
        int answer = n;
        char[] charArr = control.toCharArray();

        for (char c: charArr) {
         switch (c) {
             case 'w' :
                 answer = answer + 1;
                 break;
             case 's' :
                 answer = answer -1;
                 break;
             case 'd' :
                 answer = answer + 10;
                 break;
             case 'a' :
                 answer = answer -10;
                 break;
            }
        }
        return answer;
    }

    //3. 정수 배열 numLog가 주어집니다.
    // 처음에 numLog[0]에서 부터 시작해 "w", "a", "s", "d"로 이루어진 문자열을 입력으로 받아 순서대로 다음과 같은 조작을 했다고 합시다.
    //"w" : 수에 1을 더한다.
    //"s" : 수에 1을 뺀다.
    //"d" : 수에 10을 더한다.
    //"a" : 수에 10을 뺀다.
    //그리고 매번 조작을 할 때마다 결괏값을 기록한 정수 배열이 numLog입니다. 즉, numLog[i]는 numLog[0]로부터 총 i번의 조작을 가한 결과가 저장되어 있습니다.
    //주어진 정수 배열 numLog에 대해 조작을 위해 입력받은 문자열을 return 하는 solution 함수를 완성해 주세요.
    public String day6_3(int[] numLog) {
        String answer = "";

        for(int i = 0 ; i < numLog.length - 1 ; i++) {
            int diffNum = numLog[i+1] - numLog[i];
            switch (diffNum) {
                case 1 : answer += "w"; break;
                case -1 : answer += "s"; break;
                case 10 : answer += "d"; break;
                case -10 : answer += "a"; break;
            }
        }
        return answer;
    }

    //4.정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [i, j] 꼴입니다.
    //각 query마다 순서대로 arr[i]의 값과 arr[j]의 값을 서로 바꿉니다.
    //위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
    public int[] day6_4(int[] arr, int[][] queries) {
        int[] answer = arr;
        int temp = 0;

        for(int i = 0 ; i < queries.length ; i++) {
            temp = arr[queries[i][0]];
            arr[queries[i][0]] = arr[queries[i][1]];
            arr[queries[i][1]] = temp;
        }
        return answer;
    }

    //5.정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
    //각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 k보다 크면서 가장 작은 arr[i]를 찾습니다.
    //각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
    //단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.
    //[0, 1, 2, 4, 3]	[[0, 4, 2],[0, 3, 2],[0, 2, 2]]	[3, 4, -1]
    public int[] day6_5(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        return answer;
    }
}
