package com.example.codingTest_scoreBooster.hash;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import static java.util.stream.Collectors.*;

public class Clothing {

    /***
     * 2차원 배열로 파라미터를 받음
     * ex. ["yellow_hat", "headgear"] (0,1)
     *     ["blue_sunglasses", "eyewear"] (1,1)
     *     ["green_turban", "headgear"] (2,1)
     *
     * 1. 의상의 종류의 개수 (유형개수)
     * 2. 해당 유형의 개수 (옷의 개수)
     * 2종류의 의상에 a종류는 2개 b종류는 1개 라면 (a+1)(b+1) -1 이 된다 => 2가지가 더 추가 되는것
     *
     * [문제 해결] : 다항식을 생각해보면 쉬움
     *             옷의 종류의 개수를 n차라고 보면
     *             옷의 종류가 3개이고 옷의 개수가 a,b,c 라면
     *             (x+a)(x+b)(x+c) = x^3 + (a+b+c)x^2 + (ab+bc+ca)x + (abc) 이렇게 식이 나온다
     *             x = 1을 대입하면 1 + (a+b+c) + (ab+bc+ca) + (abc) 의 값이 나오고 맨 앞의 1은 필요없으니까 -1을 해주면
     *             (x+a)(x+b)(x+c) - 1 = (a+b+c) + (ab+bc+ca) + (abc) 와 같다
     **/
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        //의상의 종류의 개수 확인
        for (int i = 0 ; i < clothes.length; i++) {
            if(hashMap.containsKey(clothes[i][1]) && i > 0) { //옷의 종류가 똑같은 경우
                hashMap.put(clothes[i][1], hashMap.get(clothes[i][1]) + 1); //옷의 종류에 개수 +1을 시켜준다
            }else {
                hashMap.put(clothes[i][1], 1); //옷의 종류가 없는경우(신규등록)
            }
        }

        Collection<Integer> values = hashMap.values(); //collection에 hashmap의 value값들을 담는다.
        for(int value : values) {
            answer = answer * (value + 1); //(a+1)(b+1)....(n+1) 식 계산
        }
        answer = answer - 1; //위에 설명처럼 1을 빼준다.
        return answer;
    }


    /**
     * [다른 풀이법] : Stream을 활용해서 풀수있다.
     *
     * grouping() : java의 collectors 유틸리티 클래스에서 제공하는 그룹화 기능으로 주로 Stream API와 함께 사용된다.
     *              특정 key값을 기준으로 데이터를 그룹화하고, 결과를 Map<key, List<value>> 형태로 반환한다.
     *
     * @param clothes
     * @return
     */
    public int solution2(String[][] clothes) {
        int answer = 0;
        answer = Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p ->p[0] ,counting()))) //옷의 유형을 key값으로 저장하고, 해당 값을 map으로 매핑하고 카운트한다
                .values()                                                                      //p[1] : 옷의 종류로 그룹화 / p[2] : 옷이름을 추출한하고 그룹별로 카운트 한다
                .stream()
                .collect(reducing(1L, (x,y) -> x * (y+1))).intValue() -1;
        return answer;
    }

    public static void main(String[] args) {
        Clothing clothing = new Clothing();
        //clothing.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
        clothing.solution2(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}});
    }
}