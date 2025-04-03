package com.example.codingTest_all;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//크레인 인형뽑기
public class ClawMachine {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> boardList = new ArrayList<>();
        Stack<Integer> clawStack = new Stack<>();

        // 1. boardList를 열(column) 기준으로 저장 (위에서 아래로)
        for (int j = 0; j < board[0].length; j++) { // 열 기준 반복
            Stack<Integer> stack = new Stack<>();
            for (int i = board.length - 1; i >= 0; i--) { // 아래에서 위로 쌓기
                if (board[i][j] > 0) {
                    stack.push(board[i][j]);
                }
            }
            boardList.add(stack);
        }

        for (int move : moves) {
            int moveNum = move - 1; // 1번부터 시작하므로 인덱스 변환

            if (!boardList.get(moveNum).isEmpty()) {
                int stackNum = boardList.get(moveNum).pop();

                // 3. clawStack의 최상단과 비교하여 같은 경우
                if (!clawStack.isEmpty() && clawStack.peek().equals(stackNum)) {
                    clawStack.pop();
                    answer += 2;
                } else {
                    clawStack.push(stackNum);
                }
            }
        }

        return answer;
    }

    /**
     * 틀림
     * @param board
     * @param moves
     * @return
     */
    public int solution_x(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack> boardList = new ArrayList<>();
        Stack clawStack = new Stack();

        for(int i = 0; i < board.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] > 0) {
                    stack.push(board[i][j]);
                }
            }
            boardList.add(stack);
        }

        for (int i = 0; i < moves.length; i++) {
            int moveNum = moves[i] - 1;
            if(!boardList.get(moveNum).isEmpty()) {
                int stackNum = (int) boardList.get(moveNum).pop();
                if(clawStack.isEmpty()) {
                    clawStack.push(stackNum);
                }
                if(!clawStack.isEmpty() && clawStack.peek().equals(stackNum)) {
                    answer++;
                    clawStack.pop();
                }
                if(!clawStack.isEmpty() && !clawStack.peek().equals(stackNum)){
                    clawStack.push(stackNum);
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        ClawMachine clawMachine = new ClawMachine();
        clawMachine.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},new int[]{1,5,3,5,1,2,1,4});
//        clawMachine.solution(new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}},new int[]{1,2,3,4}); //0
//        clawMachine.solution(new int[][]{
//                {0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 0},
//                {0, 0, 1, 0, 0},
//                {0, 0, 1, 0, 0}
//        }, new int[]{3, 3, 3, 3}); //6
    }
}
