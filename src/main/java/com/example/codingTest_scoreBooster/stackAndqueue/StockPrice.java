package com.example.codingTest_scoreBooster.stackAndqueue;

//주식가격
public class StockPrice {

    /***
     * 해당 문제가 있던 유형이 스택/큐였는데 아무리 생각해봐도 스택이나 큐로 어떻게 풀어야하는지
     * 감이 안와서 for문으로 하나씩 비교하는것으로 풀수 밖에 없었다.
     * 그리고 문제를 이해하는데 시간이 오래걸렸는데 한번 주식이 떨어지면 유지기간이 끝이라고 생각하면 된다.
     * @param prices
     * @return
     */
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        //prices의 길이만큼 초가 진행된다.
        int sec = prices.length;
        int lastLen = prices.length;

        //각 배열을 돌면서
        for (int i = 0; i < sec; i++) {
            int count = 0;
            for(int j = i ; j < (lastLen-1); j++) {
                count++;
                if (prices[i] > prices[j+1]) {
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        //stockPrice.solution(new int[]{1, 2, 3, 2, 3}); //4,3,1,1,0
        stockPrice.solution(new int[]{5, 4, 3, 2, 1}); //1, 1, 1, 1, 0
    }
}
