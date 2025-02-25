package com.example.codingTest_scoreBooster.stackAndqueue;

import java.util.*;

public class FeatureDevelopment {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        //먼저 들어간 순서대로 확인해야하니까 queue가 필요
        Queue<Integer> queue = new LinkedList<>();
        for (int progress : progresses) {
            queue.add(progress);
        }
        int tmp =  (int) Math.ceil((100 - queue.poll()) /(double) speeds[0]);
        int count = 1;
        //progress + (speed * x) = 100 으로 x값 계산 , 소수점 무조건 반올림
        //첫번째보다 작으면 +1 / 크면 next
        int i = 1;
        while (!queue.isEmpty()) {
            int day = (int) Math.ceil((100 - queue.poll()) /(double)speeds[i]);
            if (tmp < day) { //1. tmp < day 인 경우 : count +1 해주고 tmp값에 day값 할당후 다음값 확인
                answer.add(count);
                tmp = day;
                count = 1;
            }else if(tmp > day) { //2. tmp > day 인 경우  : count +1 해주고 다음값 확인
                count++;
            }else if (tmp == day) {
                tmp = day;
                count++;
            }
            i++;
        }
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    /***
     * 큐에 담아서 하나씩 확인하는것보다 큐에 담은후 사이즈를 확인해서 값을 계산하는 풀이법
     * 기능개발에 필요한 일수 계산을 한것까지는 나도 했는데 이후 계산방식이 깔끔하게 할수있는데 나는 if문 사용을 남발한것 같다.
     * @param progresses
     * @param speeds
     * @return
     */
    public int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            //완료할 날짜 계산 -> 여기까지는 내가 생각한것이랑 동일
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if(!queue.isEmpty() && queue.peek() < date) { //큐가 비어있지않고, 현재 date가 앞에 있는 기능보다 늦게 완료될경우
                list.add(queue.size()); //list에 추가
                queue.clear(); //초기화
            }
            queue.offer(date); //아니면 큐에 추가
        }
        list.add(queue.size());//남은 배포그룹 추가

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        FeatureDevelopment featureDevelopment = new FeatureDevelopment();
        featureDevelopment.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});//[2, 1]
        //featureDevelopment.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}); //[[1, 3, 2]]
        //featureDevelopment.solution(new int[]{99, 96, 94}, new int[]{1, 3, 4}); //[1,2]
    }
}
