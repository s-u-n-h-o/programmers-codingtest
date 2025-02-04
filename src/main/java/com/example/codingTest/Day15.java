package com.example.codingTest;

import java.util.Arrays;

public class Day15 {

    //1.정수 배열 arr가 주어집니다. arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고,
    // 50보다 작은 홀수라면 2를 곱합니다. 그 결과인 정수 배열을 return 하는 solution 함수를 완성해 주세요.
    public int[] day15_1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 50 && arr[i] % 2 == 0) {
                arr[i] = arr[i] / 2;
            } else if (arr[i] < 50 && arr[i] % 2 != 0) {
                arr[i] = arr[i] * 2;
            }
        }
        return arr;
    }

    //2.정수 배열 arr가 주어집니다.
    //arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고, 50보다 작은 홀수라면 2를 곱하고 다시 1을 더합니다.
    //이러한 작업을 x번 반복한 결과인 배열을 arr(x)라고 표현했을 때,
    // arr(x) = arr(x + 1)인 x가 항상 존재합니다. 이러한 x 중 가장 작은 값을 return 하는 solution 함수를 완성해 주세요.
    //단, 두 배열에 대한 "="는 두 배열의 크기가 서로 같으며, 같은 인덱스의 원소가 각각 서로 같음을 의미합니다.
//        반복 횟수	    arr
//        0	[1, 2, 3, 100, 99, 98]
//        1	[3, 2, 7, 50, 99, 49]
//        2	[7, 2, 15, 25, 99, 99]
//        3	[15, 2, 31, 51, 99, 99]
//        4	[31, 2, 63, 51, 99, 99]
//        5	[63, 2, 63, 51, 99, 99]
//        6	[63, 2, 63, 51, 99, 99]
    public int day15_2(int[] arr) {
        int answer = 0;
        int count = 0;
        int[] beforArr = new int[arr.length];
        while(count != arr.length) {
            count = 0;
            beforArr = arr.clone();
            for(int i =0; i<arr.length; i++) {
                if(arr[i]%2 == 0 && arr[i] >= 50) {
                    arr[i] /= 2;
                }else if(arr[i]%2 != 0 && arr[i] < 50) {
                    arr[i] = arr[i]*2 +1;
                }
                if(arr[i] == beforArr[i] ) count ++;
            }
            answer ++;
        }
        return answer-1;
    }

    //3.정수가 있을 때, 짝수라면 반으로 나누고, 홀수라면 1을 뺀 뒤 반으로 나누면, 마지막엔 1이 됩니다. 예를 들어 10이 있다면 다음과 같은 과정으로 1이 됩니다.
    //10 / 2 = 5
    //(5 - 1) / 2 = 4
    //4 / 2 = 2
    //2 / 2 = 1
    //위와 같이 4번의 나누기 연산으로 1이 되었습니다.
    //정수들이 담긴 리스트 num_list가 주어질 때, num_list의 모든 원소를 1로 만들기 위해서 필요한 나누기 연산의 횟수를 return하도록 solution 함수를 완성해주세요.
    public int day15_3(int[] num_list) {
        int temp = 0;
        int count = 0;

        for(int i = 0; i < num_list.length ; i++) {
            temp = num_list[i];
            while (temp != 1) {
                if(temp % 2 == 0) {
                    temp = temp / 2;
                    count++;
                } else if(temp % 2 != 0) {
                    temp = (temp - 1) / 2;
                    count++;
                }
            }
        }
        return count;
    }

    //4.정수가 담긴 리스트 num_list가 주어질 때,
    // 리스트의 길이가 11 이상이면 리스트에 있는 모든 원소의 합을 10 이하이면 모든 원소의 곱을 return하도록 solution 함수를 완성해주세요.
    public int day15_4(int[] num_list) {
        int answer = num_list[0];

        if(num_list.length >= 11) {
            answer = Arrays.stream(num_list).sum();
        }else {
            for(int i = 0 ; i < num_list.length  - 1; i++) {
                answer = answer * num_list[i + 1];
            }
        }
        return answer;
    }

    //5.알파벳으로 이루어진 문자열 myString과 pat이 주어집니다.
    // myString의 연속된 부분 문자열 중 pat이 존재하면 1을 그렇지 않으면 0을 return 하는 solution 함수를 완성해 주세요.
    //단, 알파벳 대문자와 소문자는 구분하지 않습니다.
    public int day15_5(String myString, String pat) {
        int answer = 0;
        myString = myString.toUpperCase();
        pat = pat.toUpperCase();
        if(myString.contains(pat)) {
            answer = 1;
        }
        return answer;
    }
}
