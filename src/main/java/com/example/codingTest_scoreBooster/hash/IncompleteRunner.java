package com.example.codingTest_scoreBooster.hash;

import java.util.HashMap;
import java.util.HashSet;

public class IncompleteRunner {

    /***
     * [문제점] : 동명이인이라는 조건에 꽂혀서 hashSet으로 중복제거를 했는데 문제는 동명이인중 한명이 완주하지 못한 사람인경우
     *         동명이인을 다시 찾아야하는데 여기서 막혀서 풀지 못했다.
     * [해결책] : HashSet이 아니라 HashMap으로 풀수 있는 문제였다.
     * @param participant : 참여한 사람
     * @param completion : 완주한 사람
     * @return
     */
    public String solution1(String[] participant, String[] completion) {
        HashSet<String> hashSet = new HashSet<>();

        //hashSet을 통해서 중복이름 제거
        for (String s : participant) {
            hashSet.add(s);
        }

        //완주한 사람 확인
        for (int i = 0; i < completion.length; i++) {
            if(hashSet.contains(completion[i])) { //이름이 존재하는 경우
                hashSet.remove(completion[i]);
            }
        }

        System.out.println("hashSet.toString() = " + hashSet.stream().iterator().next());
        return hashSet.stream().iterator().next();
    }

    /***
     * [해결방법]
     * HashMap 사용
     *      getOrDefault(Objeck key , defaultVaule) : Map에서 특정키에 매핑된 값을 반환하며, 만약 해당키가 존재하지 않는다면, defaultValue를 반환합니다.
     * @param participant
     * @param completion
     * @return
     */
    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        //참가자 배열을 순회하면서, hashmap에 key는 이름으로 , 이름이 나올때마다 1씩 증가를 시킨다
        for(String s : participant) {
            hashMap.put(s, hashMap.getOrDefault(s,0) + 1);
        }

        //완주한 사람 배열을 순회하면서, hashmap에 이름을 찾아서 -1씩 감소시킨다.
        for (String s : completion) {
            hashMap.put(s, hashMap.get(s) -1 );
        }

        //완주한사람은 0이되니까 0이 안된 key값이 완주하지 못한 사람이 되는것이다.
        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) != 0) {
                answer = key;
            }
        }
        System.out.println("answer = " + answer);
        return answer;

    }

    public static void main(String[] args) {
        IncompleteRunner incompleteRunner = new IncompleteRunner ();
        incompleteRunner.solution2(new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"});
    }
}
