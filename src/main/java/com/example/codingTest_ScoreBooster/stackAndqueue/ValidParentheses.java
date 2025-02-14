package com.example.codingTest_ScoreBooster.stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;

//올바른 괄호
public class ValidParentheses {

    /**
     *        s	    answer
     *     "()()"	true
     *     "(())()"	true
     *     ")()("	false
     *     "(()("	false
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
            System.out.println("parentheses.peek() : " + parentheses.peek());
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

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        //validParentheses.solution("()()"); //true
        //validParentheses.solution("(())()");//true
        //validParentheses.solution(")()(");//false
        //validParentheses.solution("(()(");//false
        validParentheses.solution("())(()");//false
    }

}
