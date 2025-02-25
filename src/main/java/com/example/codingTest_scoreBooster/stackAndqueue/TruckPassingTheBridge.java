package com.example.codingTest_scoreBooster.stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;

//다리를 지나는 트럭
public class TruckPassingTheBridge {

    /***
     *  [문제점]
     *  1. 다리위의 트럭의 상태를 유지하지 않았다.
     *  2. 트럭이 건너는데 걸리는 시간은 무게가 아니라 bridge_length인데 해당 truck_weights를 length로 나눠서 시간을 체크한후에 시간에 바로 추가함으로써 문제가 생겼다
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sec = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int truck : truck_weights) {
            queue.offer(truck);
        }

        while (!queue.isEmpty()) {
            //1. truck_weight 트럭의 kg수를 length로 나눈다. -> 시간이 얼만큼 걸릴지 확일할수있다.
            sec = queue.peek() / bridge_length;
            int preTruck = queue.poll();

            //2. 다음 트럭의 kg를 확인해서 앞에 합산값이 weight를 넘는지 확인한다.
            //다음 값
            if(!queue.isEmpty()) {
                if (queue.peek() + preTruck > 10 || queue.size() == truck_weights.length) {
                    sec = preTruck / bridge_length;
                    answer += sec;
                } else if (queue.peek() + preTruck < 10) {
                    sec = preTruck / bridge_length;
                    answer += sec;
                    queue.poll(); //그다음 트럭도 동일한시간에 넘어가기때문에 삭제
                }
            }
        }
        answer += sec;
        System.out.println("answer = " + answer);
        return answer;
    }

    public int solution1(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; //총 소요시간
        int bridgeWeight = 0; //현재 다리위의 총 무게
        int index = 0; //대기중인 트럭 인덱스
        //1. 다리 위의 상태를 관리하는 (트럭무게 + 들어간 시간)
        Queue<int[]> queue = new LinkedList<>();

        while (index < truck_weights.length || !queue.isEmpty()) {
            answer++;

            if(!queue.isEmpty() && answer - queue.peek()[1] >= bridge_length) { //다리 위에있는 트럭이 전부 다리를 건넜는지 확인
                bridgeWeight -= queue.poll()[0];                                //answer - queue.peek()[1] : 현재시간에서 다리에 올라간 시간을뺀다 (경과 시간 계산)
            }

            if(index < truck_weights.length && bridgeWeight + truck_weights[index] <= weight) { //새로운 트럭 올릴수 있는지 확인
                queue.offer(new int[]{truck_weights[index], answer});
                bridgeWeight += truck_weights[index];
                index++;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        TruckPassingTheBridge t = new TruckPassingTheBridge();
        //t.solution(2, 10, new int[]{7,4,5,6}); //8
        t.solution1(100, 100, new int[]{10}); //101
        //t.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}); //110
        //t.solution(10, 20, new int[]{10,10,10}); //31
    }
}
