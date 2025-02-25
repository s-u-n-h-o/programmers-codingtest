package com.example.codingTest_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day13 {

    // 1. 정수 리스트 num_list와 정수 n이 주어질 때,
    // n 번째 원소부터 마지막 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.
    public int[] day13_1(int[] num_list, int n) {
        List answer = new ArrayList<>();

        for(int i = n - 1 ; i < num_list.length ; i++) {
            answer.add(num_list[i]);
        }
        return answer.stream().mapToInt(j->(int) j).toArray();

        //다른풀이법
        //자꾸 list로만 풀려고 하는버릇을 고처야겠다. 배열에서 그냥 바로 만들면되는데 효율성이 떨어지도록 작성한것 같다.
        //answer = Arrays.copyOfRange(num_list,0,n);
    }

    //2. 정수 리스트 num_list와 정수 n이 주어질 때,
    // num_list를 n 번째 원소 이후의 원소들과 n 번째까지의 원소들로 나눠
    // n 번째 원소 이후의 원소들을 n 번째까지의 원소들 앞에 붙인 리스트를 return하도록 solution 함수를 완성해주세요.
    public int[] day13_2(int[] num_list, int n) {
        List answer = new ArrayList();
        for(int i = n ; i < num_list.length ; i++) {
            answer.add(num_list[i]);
        }
        for(int j = 0 ; j < n; j++) {
            answer.add(num_list[j]);
        }

        return answer.stream().mapToInt(i ->(int) i).toArray();

        //다른 풀이법
        //stream으로 범위를 설정한뒤에 i -> num_list[(i + n) 위치를 이동시키고, % num_list.length 배열이 초과되면 안쪽으로 채운다
        //return IntStream.range(0, num_list.length).map(i -> num_list[(i + n) % num_list.length]).toArray();
    }

    //3.문자열 리스트 str_list에는 "u", "d", "l", "r" 네 개의 문자열이 여러 개 저장되어 있습니다.
    // str_list에서 "l"과 "r" 중 먼저 나오는 문자열이 "l"이라면 해당 문자열을 기준으로 왼쪽에 있는 문자열들을 순서대로 담은 리스트를,
    // 먼저 나오는 문자열이 "r"이라면 해당 문자열을 기준으로 오른쪽에 있는 문자열들을 순서대로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
    // "l"이나 "r"이 없다면 빈 리스트를 return합니다.
    public String[] day13_3(String[] str_list) {
        String[] answer = {};
        for(int i = 0 ; i < str_list.length; i++) {
            if(str_list[i].equals("l")){
                answer = Arrays.copyOfRange(str_list, 0, i);
                break;
            } else if (str_list[i].equals("r")) {
                answer = Arrays.copyOfRange(str_list, i + 1, str_list.length);
                break;
            }
        }
        return answer;
    }

    //4.정수 리스트 num_list와 정수 n이 주어질 때,
    // num_list의 첫 번째 원소부터 n 번째 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.
    public int[] day13_4(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        list = list.subList(0, n);

        return list.stream().mapToInt(j->j).toArray();
    }

    //5. 정수 리스트 num_list와 정수 n이 주어질 때,
    // num_list의 첫 번째 원소부터 마지막 원소까지 n개 간격으로 저장되어있는 원소들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
    public int[] day13_5(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < num_list.length;) {
            list.add(num_list[i]);
            i = i+n;
        }
        return list.stream().mapToInt(i->i).toArray();

        //추가 설명
        //list를 쓰는이유가 배열은 배열의 길이가 고정되기때문에 얼만큼의 길이가 필요한지 모르기때문에 list만 사용한건데

        //int N = num_list.length % n == 0 ? num_list.length / n : num_list.length / n + 1;
        //위와 같이 전체길이에서 간격(n)을 나눠서 길이를 미리 확인하고 진행하면 훨씬 빠르게 할수있다.
    }
}
