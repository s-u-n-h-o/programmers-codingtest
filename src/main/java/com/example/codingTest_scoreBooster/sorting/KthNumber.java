package com.example.codingTest_scoreBooster.sorting;

import java.util.Arrays;

//k번쨰 수
public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int start = 0;
        int end = 0;

        for (int i = 0; i < commands.length; i++) {
            start = commands[i][0]-1;
            end = commands[i][1];

            int[] arr = Arrays.stream(Arrays.copyOfRange(array,start,end)).sorted().toArray();
            int tmp = arr[commands[i][2]-1];
            answer[i] = tmp;
        }

        return answer;
    }

    public static void main(String[] args) {
        KthNumber kthNumber = new KthNumber();
        kthNumber.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}); //[5, 6, 3]
    }
}
