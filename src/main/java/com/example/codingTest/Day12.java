package com.example.codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day12 {

    //1.정수 n과 정수 3개가 담긴 리스트 slicer 그리고 정수 여러 개가 담긴 리스트 num_list가 주어집니다.
    // slicer에 담긴 정수를 차례대로 a, b, c라고 할 때, n에 따라 다음과 같이 num_list를 슬라이싱 하려고 합니다.
    //n = 1 : num_list의 0번 인덱스부터 b번 인덱스까지
    //n = 2 : num_list의 a번 인덱스부터 마지막 인덱스까지
    //n = 3 : num_list의 a번 인덱스부터 b번 인덱스까지
    //n = 4 : num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
    //올바르게 슬라이싱한 리스트를 return하도록 solution 함수를 완성해주세요.
    // --- 테스트3이랑 테스트13 뭔데... -> 찾음 n= 4 일때 for문 조건문이 이상했음ㅠ
    public int[] day12_1(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        List<Integer> list = new ArrayList();
        List<Integer> list2 = new ArrayList();
        list = Arrays.stream(num_list).boxed().collect(Collectors.toList());

        switch (n) {
            case 1 :
                list = list.subList(0, slicer[1] + 1);break;
            case 2 :
                list = list.subList(slicer[0] , list.size());break;
            case 3 :
                list = list.subList(slicer[0], slicer[1] + 1);break;
            case 4 :
                for(int i = slicer[0]; i <= slicer[1];) {
                    list2.add(list.get(i));
                    i = i + slicer[2];
                }
                answer = list2.stream().mapToInt(j->j).toArray();break;
        }
        if(n != 4) {
            answer = list.stream().mapToInt(k->k).toArray();
        }
        return answer;
    }

    //2.정수 리스트 num_list가 주어질 때, 첫 번째로 나오는 음수의 인덱스를 return하도록 solution 함수를 완성해주세요. 음수가 없다면 -1을 return합니다.
    public int day12_2(int[] num_list, int[][] ints) {
        int answer = -1;

        for(int i = 0 ; i < num_list.length; i++) {
            if(num_list[i] < 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    //3.정수 배열 arr와 2개의 구간이 담긴 배열 intervals가 주어집니다.
    //intervals는 항상 [[a1, b1], [a2, b2]]의 꼴로 주어지며 각 구간은 닫힌 구간입니다. 닫힌 구간은 양 끝값과 그 사이의 값을 모두 포함하는 구간을 의미합니다.
    //이때 배열 arr의 첫 번째 구간에 해당하는 배열과 두 번째 구간에 해당하는 배열을 앞뒤로 붙여 새로운 배열을 만들어 return 하는 solution 함수를 완성해 주세요.
    public int[] day12_3(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        int ed_idx = 0;
        int st_idx = 0;

        for(int i = 0 ; i < intervals.length; i++) {
            st_idx = intervals[i][0];
            ed_idx = intervals[i][1];
            for(int j = st_idx ; j <= ed_idx; j++) {
                list.add(arr[j]);
            }
        }
        return list.stream().mapToInt(k->k).toArray();
    }

    //4.정수 배열 arr가 주어집니다. 배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 return 하는 solution 함수를 완성해 주세요.
    //단, arr에 2가 없는 경우 [-1]을 return 합니다.
    public int[] day12_4(int[] arr) {
        int[] answer;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        outerloop:
        for(int i = 0 ; i < arr.length ; i++) {
          if(arr[i] == 2) {
              for(int j = arr.length - 1; i <= j ; j--) {
                  if(arr[j] == 2) {
                      list = list.subList(i,j + 1);
                      cnt++;
                      break outerloop;
                  }
              }
          }
        }
        if(cnt == 0) {
            answer = new int[1];
            answer[0] = -1;
        }else {
            answer = list.stream().mapToInt(j->j).toArray();
        }
        return answer;
    }

    //5.정수 배열 arr와 query가 주어집니다.
    //query를 순회하면서 다음 작업을 반복합니다.
    //짝수 인덱스에서는 arr에서 query[i]번 인덱스를 제외하고 배열의 query[i]번 인덱스 뒷부분을 잘라서 버립니다.
    //홀수 인덱스에서는 arr에서 query[i]번 인덱스는 제외하고 배열의 query[i]번 인덱스 앞부분을 잘라서 버립니다.
    //위 작업을 마친 후 남은 arr의 부분 배열을 return 하는 solution 함수를 완성해 주세요.
    public int[] day12_5(int[] arr, int[] query) {
        int[] answer = {};
        //array -> list
        List<Integer> list =  Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        for(int i = 0 ; i < query.length ; i++) {
            //짝수
            if((i % 2) == 0) {
                list = list.subList(0, query[i] + 1);
            }else if((i % 2) != 0){
                //홀수
                list = list.subList(query[i] , list.size());
            }
        }
        answer = list.stream().mapToInt(j-> (int) j).toArray();
        return answer;
    }
}
