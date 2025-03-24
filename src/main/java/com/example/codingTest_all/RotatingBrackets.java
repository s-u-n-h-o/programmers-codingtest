package com.example.codingTest_all;

import java.util.Arrays;
import java.util.Stack;

//괄호 회전하기
public class RotatingBrackets {
    public int solution(String s) {
        int answer = 0;
        int start = 0;
        String[] str = s.split("");
        Stack<String> stack = new Stack<>();

        //1.총 회전수
        while (start < str.length) {
            boolean checkBracket = true;
            for(int i = 0; i < str.length; i++) {
                if(str[i].equals("(") || str[i].equals("{") || str[i].equals("[")) {
                    stack.push(str[i]);
                }
                else if(!stack.isEmpty() && (str[i].equals(")") || str[i].equals("}") || str[i].equals("]"))) {
                    String temp = stack.peek();
                    if ((temp.equals("(") && str[i].equals(")")) ||
                            (temp.equals("{") && str[i].equals("}")) ||
                            (temp.equals("[") && str[i].equals("]"))) {
                        stack.pop();
                    } else {
                        checkBracket = false;
                        break;
                    }
                }
                else {
                    checkBracket = false;
                    break;
                }
            }

            if (!stack.isEmpty()) checkBracket = false;
            if(checkBracket) {answer++;}

            //문자열 회전
            String strTemp = str[0];
            for (int i = 0; i < str.length - 1; i++) {
                str[i] = str[i + 1];
            }
            str[str.length - 1] = strTemp;
            start++;
            stack.clone();
        }

        System.out.println("answer: " + answer);
        return answer;
    }

    public static void main(String[] args) {
        RotatingBrackets rotatingBrackets = new RotatingBrackets();
        rotatingBrackets.solution("[](){}");
//        rotatingBrackets.solution("}]()[{");
//        rotatingBrackets.solution("[)(]");
//        rotatingBrackets.solution("}}}");
//        rotatingBrackets.solution("()(()(()())())");
    }
}
