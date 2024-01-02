package com.example.codingTest;

public class Day4 {

    //1. 정수 num과 n이 매개 변수로 주어질 때,
    //num이 n의 배수이면 1을 return n의 배수가 아니라면 0을 return하도록 solution 함수를 완성해주세요.
    public int day4_1(int num, int n) {
        int answer = num % n == 0 ? 1 : 0;

        return answer;
    }

    //2. 정수 number와 n, m이 주어집니다.
    //number가 n의 배수이면서 m의 배수이면 1을 아니라면 0을 return하도록 solution 함수를 완성해주세요.
    public int day4_2(int number, int n, int m) {
        int answer = number % n == 0 && number % m == 0 ? 1 : 0;

        return answer;
    }

    //3. 양의 정수 n이 매개변수로 주어질 때
    //n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return
    //n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는 solution 함수를 작성해 주세요.
    public int day4_3(int n) {
        int answer = 0;
        int divisionValue;
        int i;
        int div;

        //1. 홀수인지,짝수인지
        if(n%2 == 0) {
            divisionValue = 2;
            i = 2;
            div = 0;
        }else{
            divisionValue = 1;
            i = 3;
            div = 1;
        }

        while (i <= n) {
            answer += Math.pow(i, divisionValue);
            i = 2 + i;
        }

        return answer + div;

        //다른사람 풀이
        // 1. 더하는것이 아니라 해당 값에서 -2 씩하면 짝수의 자기자신 2도 한번에 계산할수 있다.
        // 2. 제곱이니까 숫자를 두번 더해주면 된다.. 내 코드는 너무 하나씩 해결하면서 막힐때마다 자꾸 변수를 추가해줘서 복잡하고 가독성도 떨어지는것같다.
        //for(int i = n; i >= 0; i -= 2) {answer += (n % 2 == 0) ? i * i : i};
    }

    //4. 문자열에 따라 다음과 같이 두 수의 크기를 비교하려고 합니다.
    //두 수가 n과 m이라면
    //">", "=" : n >= m
    //"<", "=" : n <= m
    //">", "!" : n > m
    //"<", "!" : n < m
    //두 문자열 ineq와 eq가 주어집니다. ineq는 "<"와 ">"중 하나고, eq는 "="와 "!"중 하나입니다.
    //그리고 두 정수 n과 m이 주어질 때, n과 m이 ineq와 eq의 조건에 맞으면 1을 아니면 0을 return하도록 solution 함수를 완성해주세요.
    public int day4_4(String ineq, String eq, int n, int m) {
        int answer = 0;
        String str = ineq + eq;

        if(eq.equals("=")) {
            if(str.equals(">=")) {
                answer = n >= m ? 1 : 0;
            }else if(str.equals("<=")) {
                answer = n <= m ? 1 : 0;
            }
        } else if(eq.equals("!")) {
            if(str.equals(">!")) {
                answer = n > m ? 1 : 0;
            } else if(str.equals("<!")) {
                answer = n < m ? 1 : 0;
            }
        }

        return answer;
    }

    //5. 두 정수 a, b와 boolean 변수 flag가 매개변수로 주어질 때, flag가 true면 a + b를 false면 a - b를 return 하는 solution 함수를 작성해 주세요.
    public int day4_5(int a, int b, boolean flag) {
        int answer = flag ? a + b : a - b;

        return answer;
    }

}
