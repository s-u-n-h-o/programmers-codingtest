package com.example.codingTest_scoreBooster.bruteForce;

import java.util.ArrayList;
import java.util.List;

//모의고사
public class MockExam {
    public int[] solution(int[] answers) {
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        int[] count = new int[3];

        int st1=0;
        int st2=0;
        int st3=0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) count[0]++;
            if (answers[i] == student2[i % student2.length]) count[1]++;
            if (answers[i] == student3[i % student3.length]) count[2]++;
        }

        //최대값을 가진 사람순서대로
        int bestScore = Math.max(count[0], Math.max(count[1], count[2]));
        List<Integer> bestScoreList = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if(count[i] == bestScore) {
                bestScoreList.add(i+1);
            }
        }
        return bestScoreList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        MockExam exam = new MockExam();
//        exam.solution(new int[]{1,2,3,4,5});
        exam.solution(new int[]{1,3,2,4,2});
    }
}
