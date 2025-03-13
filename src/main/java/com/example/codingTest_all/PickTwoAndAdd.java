package com.example.codingTest_all;

import java.util.Arrays;
import java.util.HashSet;

//두개 뽑아서 더하기
public class PickTwoAndAdd {

    public int[] solution(int[] numbers) {
        numbers = Arrays.stream(numbers).sorted().toArray();

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0 ; i < numbers.length ; i++) {
            for(int j = i+1 ; j < numbers.length; j++) {
                hashSet.add(numbers[i]+numbers[j]);
            }
        }
        return Arrays.stream(hashSet.stream().mapToInt(i->i).toArray()).sorted().toArray();
    }

    public static void main(String[] args) {
        PickTwoAndAdd pickTwoAndAdd = new PickTwoAndAdd();
        int[] numbers = {2,1,3,4,1};
        int[] numbers1 = {5, 0, 2, 7};
        int[] numbers2 = {0,0};
//        pickTwoAndAdd.solution(numbers);
//        pickTwoAndAdd.solution(numbers1);
        pickTwoAndAdd.solution(numbers2);

    }
}
