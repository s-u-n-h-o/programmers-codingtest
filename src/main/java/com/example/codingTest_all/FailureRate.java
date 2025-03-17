package com.example.codingTest_all;

import java.util.*;

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        HashMap<Integer, Double> map = new HashMap<>();
        int totalStage = stages.length;

        for (int i = 1; i <= N ; i++) {
            int findCount = i;
            int failStage = (int) Arrays.stream(stages).filter(n -> n <= findCount).count(); //스테이지를 클리어하지 못한 유저수 카운트
            stages = Arrays.stream(stages).filter(n ->  n > findCount).toArray(); //클리어하지 못한 유저수를 제외하고 스테이지 배열수정

            //0으로 나눴을때 NaN오류로 if문 넣기
            if(failStage == 0) {
                map.put(findCount, (double)0);
            }else {
                map.put(findCount, (double) failStage/totalStage); //실패율 계산
            }
            totalStage -= failStage;
        }

        //정렬
        answer = map.entrySet()
                .stream()
                .sorted((key1, key2) -> {
                    int compare = key2.getValue().compareTo(key1.getValue());
                    if(compare != 0) {
                        return compare;
                    }else {
                        return key1.getKey().compareTo(key2.getKey()); //값이 같으면 Key값이 더 작은순으로 정렬
                    }
                })
                .map(entry -> Integer.parseInt(String.valueOf(entry.getKey())))
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }

    /***
     * Class로 따로 빼서 계산하기
     * @param N
     * @param stages
     * @return
     */
    public int[] solution2(int N, int[] stages) {
        int players = stages.length;
        int[] stagePlayers = new int[N + 2]; //0번째 인덱스를 사용하지 않으면서 N+1번 인덱스까지 사용하기 위해서 -> 인덱스를 스테이지 번호와 매칭시켜 직관적으로 관리가능
        for(int stage : stages) {
            stagePlayers[stage] += 1; //0스테이지 : 0 명 , 1스테이지 : 1명 , 2스테이지 : 3명 ... 이렇게 하면 filter사용해서 count할 필요가 없으니까
        }

        int reminingPlayers = players;
        List<Stage> stageList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            double failer = (double) stagePlayers[i] / reminingPlayers; //실패율 계산하기
            reminingPlayers -= stagePlayers[i];

            Stage s = new Stage(i, failer);
            stageList.add(s);
        }
        //Collections.sort(List<T>)는 T가 Comparable<T>를 구현해야한다.
        Collections.sort(stageList, Collections.reverseOrder()); //stage객체 리스트를 정렬 , 기본정렬방식의 내림차순으로 정렬


        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).id;
        }
        return answer;
    }

    class Stage implements Comparable<Stage> {
        public int id;
        public double failer;

        public Stage(int id, double failer) {
            this.id = id;
            this.failer = failer;
        }

        @Override
        public int compareTo(Stage o) {
            if(failer < o.failer) {
                return -1;
            }
            if(failer > o.failer) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        FailureRate failureRate = new FailureRate();
        failureRate.solution2(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
//        failureRate.solution(4, new int[]{4,4,4,4,4});

    }
}
