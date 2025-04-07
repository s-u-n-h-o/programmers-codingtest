package com.example.codingTest_all;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//카드 뭉치
public class CardDeck {
    /***
     *      cards1	                cards2	            goal	                        result
     * ["i", "drink", "water"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"Yes"
     * ["i", "water", "drink"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"No"
     */
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yse";
        Stack<String> goalStack = new Stack<>();
        Stack<String> card1Stack = new Stack<>();
        Stack<String> card2Stack = new Stack<>();
        for(int i = goal.length - 1; i >= 0; i--) {
            goalStack.push(goal[i]);
        }
        for(int i = cards1.length - 1; i >= 0; i--) {
            card1Stack.push(cards1[i]);
        }
        for(int i = cards2.length - 1; i >= 0; i--) {
            card2Stack.push(cards2[i]);
        }

        //goalStack하나를 뽑아서 List1이랑 List2에 동일한 값이 있는지 확인 없으면 바로 No
        while (!goalStack.isEmpty()) {
            String goalCheck = goalStack.pop();
            if(!card1Stack.isEmpty() && card1Stack.peek().equals(goalCheck)) {
                card1Stack.pop();
            }else if(!card2Stack.isEmpty() && card2Stack.peek().equals(goalCheck)) {
                card2Stack.pop();
            }else {
                return "No";
            }
        }
        return answer;
    }

    /**
     * Queue 큐 : FIFO로 먼저들어간값이 먼저나오는 구조
     * 큐를 생각못하고 stack만 생각하니까 solution1처럼 가독성이 떨어지는 for문을 작성한거임
     * @return
     */
    public String solution2(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> goalQueue = new LinkedList<>();
        Queue<String> card1Queue = new LinkedList<>();
        Queue<String> card2Queue = new LinkedList<>();
        for(String goalCheck : goal) {
            goalQueue.offer(goalCheck);
        }
        for(String card1 : cards1) {
            card1Queue.offer(card1);
        }
        for(String card2 : cards2) {
            card2Queue.offer(card2);
        }

        while (!goalQueue.isEmpty()) {
            String goalCheck = goalQueue.poll();
            if(!card1Queue.isEmpty() && card1Queue.peek().equals(goalCheck)) {
                card1Queue.remove();
            }else if(!card2Queue.isEmpty() && card2Queue.peek().equals(goalCheck)) {
                card2Queue.remove();
            }else {
                return "No";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
//        deck.solution2(new String[]{"i", "drink", "water"},new String[]{"want", "to"},new String[]{"i", "want", "to", "drink", "water"}); //yes
        deck.solution2(new String[]{"i", "water", "drink"},new String[]{"want", "to"},new String[]{"i", "want", "to", "drink", "water"}); //no
    }
}
