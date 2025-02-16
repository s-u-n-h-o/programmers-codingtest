package com.example.codingTest_ScoreBooster.stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;

//올바른 괄호
public class ValidParentheses {
    /***
     * [문제 틀림]
     * 1. 일단 문제를 너무 꼬아서 생각했다.
     * 2. (()) <- 이 부분을 푼다고 생각하면서 앞과 뒤의 값이 동일한지 동일하지 않은지 2분법으로 생각해버렸다
     * @param s
     * @return
     */
    boolean solution(String s) {
        boolean answer = true;
        int balance = 1;

        Queue<String> parentheses = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            parentheses.add(String.valueOf(s.charAt(i))); // ()()
        }

        String chkParentheses = parentheses.poll(); //첫번째 값
        if(chkParentheses.equals(")")) {
            System.out.println("false");
            return false;
        }

        while (!parentheses.isEmpty()) {
            System.out.println("chkParentheses : " + chkParentheses);
            System.out.println("parentheses.peek : " + parentheses.peek());
            if(chkParentheses.equals(parentheses.peek())) { //앞의 값이랑 뒤의값이 동일한경우
                balance++;
                chkParentheses = parentheses.poll();
            } else {
                //틀린경우 그 다음에 값이 blance 카운트와 동일한지 확인
                for(int i = 0 ; i < balance; i++) {//( ) 안같으니까
                    if(chkParentheses.equals(parentheses.peek())) { //)랑 (랑 같으면
                        System.out.println("false");
                        return false;
                    }
                    parentheses.remove();
                }
                chkParentheses = parentheses.poll();
                balance = 1;
            }
        }
        System.out.println("true");
        return answer;
    }

    /**
     * 다음 기호랑 비교하는것이 아니라 카운트값을 통해서 값이 일치하는지 확인하는방법으로 문제풀이
     * @param s
     * @return
     */
    boolean solution1(String s) {
        int count = 0;

        Queue<String> parentheses = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            parentheses.add(String.valueOf(s.charAt(i)));
        }

        if(parentheses.peek().equals(")")) {
            return false;
        }

        //stack에서 하나씩 꺼내서 확인하기
        for (int i = 0; i < s.length(); i++) {
            if(parentheses.peek().equals("(")) {
                count++;
            } else if (parentheses.peek().equals(")")) {
                count--;
            }
            parentheses.remove();

            if(count < 0) { //음수일경우 "())(()"
                return false;
            }
        }
        return count == 0 ? true : false;
    }

    /***
     *  solution1 보다 좀더 정리해서 간결하게
     * @param s
     * @return
     */
    boolean solution2(String s) {
        int count = 0;
        boolean answer = true;

        Queue<String> parentheses = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            parentheses.add(String.valueOf(s.charAt(i)));
        }

        //stack에서 하나씩 꺼내서 확인하기
        for (int i = 0; i < s.length(); i++) {
            if(parentheses.peek().equals("(")) {
                count++;
            }
            if(parentheses.peek().equals(")")) {
                count--;
            }
            if(count < 0) {
                answer = false;
                break;
            }
            parentheses.remove();
        }
        return answer;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        //validParentheses.solution1("()()"); //true
        //validParentheses.solution1("(())()");//true
        //validParentheses.solution1(")()(");//false
        //validParentheses.solution1("(()(");//false
        validParentheses.solution1("())(()");//false
    }

}
