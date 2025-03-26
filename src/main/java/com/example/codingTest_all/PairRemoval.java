package com.example.codingTest_all;

import java.util.LinkedList;
import java.util.Stack;

//짝지어 제거하기
public class PairRemoval {

    /***
     * 효율성에서 탈락함
     * [이유]
     * 1. ArrayList.remove가 시간복잡도가 O(n)이기때문에 효율성이 떨어짐
     * 2. SubString 사용 -> subString은 새로운 메모리 공간을 할당하고 문자열을 옮기기때문 효율성 하락
     * @param str
     * @return
     */
    public int solution(String str) {
        //같은 알파벳으로 붙어있는 문자열 제거
        LinkedList<String> list = new LinkedList<>();
        char startChar;
        char endChar;

        for (int i = 0; i < str.length(); i++) {
            list.add(str.substring(i, i+1));
        }
        for(int i = 0; i < list.size() -1;) {
            if(list.get(i).equals(list.get(i+1))) { //동일하면
                list.remove(i);
                list.remove(i);
                i = 0;
            }else {
                i++;
            }
        }
        System.out.println(list.size() == 0 ? 1 : 0);
        //문자열 합친후 계속 확인하기
        return list.size() == 0 ? 1 : 0;
    }

    /**
     * 100만건이 넘는 값들은 Stack으로 풀어서 시간복잡도를 O(n)으로 풀어야한다.
     * @param str
     * @return
     */
    public int solution2(String str) {
        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()) {
            if(!stack.isEmpty() && stack.peek().equals(ch)) {
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        System.out.println(stack.size() == 0 ? 1 : 0);
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        PairRemoval pair = new PairRemoval();
        pair.solution2("baabaa"); //1
//        pair.solution2("cdcd"); //0
    }
}
