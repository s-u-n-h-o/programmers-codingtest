package com.example.codingTest_all;

//행렬의 곱셈
public class MatrixMultiplication {
     /**
     * 3중 for문 사용하여 개발
     *
     * 배열의 곱셈의 크기를 구할때
     * ( a2 * b3 ) * ( c3 * d2) = a2 * d2 이렇게 생성된다.
     * arr1.length = 행의 개수
     * arr[0].length = 열의 개수
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[][] solution2(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int multiplication = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                multiplication =0;
                for (int k = 0; k < arr2.length; k++) {
                    multiplication += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = multiplication;
            }
        }
        return answer;
    }

    /**
     * 1. 3중 for문 쓰기싫어서 해보려했는데 테스트코드는 통과하지만
     *    문제 제출시 런타임 오류 터짐
     * @param arr1
     * @param arr2
     * @return
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[1].length];
        //1행1열,1행2열,3행3열
        //행고정값과, 열고정값이 들어감
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;
        int count = 0;
        int multiplication = 0;
        int lenCount=0;
        int jcount = 0;
        for (int i = 0; i < arr1Len; i++) {
            count = 0;
            lenCount=0;
            jcount = 0;
            for (int j = 0; j < arr2Len * arr2Len;) {
                System.out.println("arr1[" + i + "][" + j + "]" + "arr2[" + j + "][" + count + "]");
                multiplication += arr1[i][j] * arr2[j][count];
                if(j != 0 && (j+1) % arr2Len == 0) {
                    count++;
                    answer[i][jcount++] = multiplication;
                    multiplication = 0;
                    j = 0;
                }else {
                    j++;
                }
                lenCount++;
                if (lenCount == arr2Len * arr2Len) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MatrixMultiplication mat = new MatrixMultiplication();
        mat.solution2(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}},new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});
        //mat.solution2(new int[][]{{1,4}, {3,2}, {4,1}},new int[][]{{3, 3}, {3,3}});
    }
}
