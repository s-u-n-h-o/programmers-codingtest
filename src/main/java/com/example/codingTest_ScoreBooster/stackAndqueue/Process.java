package com.example.codingTest_ScoreBooster.stackAndqueue;

import java.util.PriorityQueue;
import java.util.Queue;

//프로세스
public class Process {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        for (int i : priorities) { //내림차순으로 정렬
            queue.offer(i);
        }
        while (!queue.isEmpty()) { //큐가 비어있을때 까지 반복
            for (int i = 0; i < priorities.length; i++) { //원래 문서대로 검사진행
                if(queue.peek() == priorities[i]) { //가장 우선순위가 높은 문서인지 확인
                    queue.poll();
                    answer++;

                    if (location == i) {
                        System.out.println(answer);
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Process process = new Process();
        process.solution(new int[]{2, 1, 3, 2}, 2);
        //process.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }
}