package com.example.codingTest;

import java.util.Arrays;

public class Day5 {

    //1.문자열 code가 주어집니다.
    //code를 앞에서부터 읽으면서 만약 문자가 "1"이면 mode를 바꿉니다. mode에 따라 code를 읽어가면서 문자열 ret을 만들어냅니다.
    //mode는 0과 1이 있으며, idx를 0 부터 code의 길이 - 1 까지 1씩 키워나가면서 code[idx]의 값에 따라 다음과 같이 행동합니다.
    //mode가 0일 때
    //code[idx]가 "1"이 아니면 idx가 짝수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
    //code[idx]가 "1"이면 mode를 0에서 1로 바꿉니다.
    //mode가 1일 때
    //code[idx]가 "1"이 아니면 idx가 홀수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
    //code[idx]가 "1"이면 mode를 1에서 0으로 바꿉니다.
    //문자열 code를 통해 만들어진 문자열 ret를 return 하는 solution 함수를 완성해 주세요.
    //단, 시작할 때 mode는 0이며, return 하려는 ret가 만약 빈 문자열이라면 대신 "EMPTY"를 return 합니다.
    public String day5_1(String code) {
        String answer = "";
        int mode = 0;
        String ret = "";
        char[] charArr = code.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            //1. 문자열이 "1"인지 확인
            if(charArr[i] == '1') {
                mode = mode == 0 ? 1 : 0; //mode 변경
            }else {
                if(mode == 1 && (i % 2 != 0)) {
                    ret += String.valueOf(charArr[i]);
                }else if(mode == 0 && (i % 2 == 0)){
                    ret += String.valueOf(charArr[i]);
                }
            }
        }

        answer = ret.equals("") ? "EMPTY" : ret;
        return answer;

        //다른풀이
        //나는 mode구분값을 나누는데 if조건문만 생각했었는데
        //if (i % 2 == mode) 이런식으로 홀수면 1 이고 짝수면 0 으로 해결하면 된다!!
        /*
               StringBuilder answer = new StringBuilder();
                int mode = 0;
                for (int i = 0; i < code.length(); i++) {
                    char current = code.charAt(i);
                    if (current == '1') {
                        mode = mode == 0 ? 1 : 0;
                        continue;
                    }

                    if (i % 2 == mode) {
                        answer.append(current);
                    }
                }
        */
    }

    //2. 두 정수 a, d와 길이가 n인 boolean 배열 included가 주어집니다.
    // 첫째항이 a, 공차가 d인 등차수열에서 included[i]가 i + 1항을 의미할 때,
    // 이 등차수열의 1항부터 n항까지 included가 true인 항들만 더한 값을 return 하는 solution 함수를 작성해 주세요.
    public int day5_2(int a, int d, boolean[] included) {
        int answer = 0;

        for (boolean bool: included) {
            if(bool == true) {
                answer += a;
            }
            a = a + d;
        }
        return answer;

        //다른 풀이
        //스트림으로 풀이가능
        //IntStream.range() : IntStream을 이용한 반복문계산을 할수있다
        /*
        return IntStream.range(0, included.length).map(idx -> included[idx]?a+(idx*d):0).sum();
         */
    }

    //3.1부터 6까지 숫자가 적힌 주사위가 세 개 있습니다. 세 주사위를 굴렸을 때 나온 숫자를 각각 a, b, c라고 했을 때 얻는 점수는 다음과 같습니다.
    //세 숫자가 모두 다르다면 a + b + c 점을 얻습니다.
    //세 숫자 중 어느 두 숫자는 같고 나머지 다른 숫자는 다르다면 (a + b + c) × (a2 + b2 + c2 )점을 얻습니다.
    //세 숫자가 모두 같다면 (a + b + c) × (a2 + b2 + c2 ) × (a3 + b3 + c3 )점을 얻습니다.
    //세 정수 a, b, c가 매개변수로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
    public int day5_3(int a, int b, int c) {
        int answer = 0;
        if(a != b && a!= c && b != c ) { //세 숫자가 다른경우
            answer = a + b + c;
        }else if(a == b && a == c && b ==c) { //세 숫자가 모두 동일한 경우
            answer = (a + b + c) * ((a*a) + (b*b) + (c*c)) *  ((a*a*a) + (b*b*b) + (c*c*c));
        }else {
            answer = (a + b + c) * ((a*a) + (b*b) + (c*c));
        }
        return answer;
    }

    //4.정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.
    public int day5_4(int[] num_list) {
        int answer = 0;
        double squareOfSum = Math.pow(Arrays.stream(num_list).sum(), 2); //합의 제곱
        int product = 0; //원소들의 곱
        int preNum = 1;
        for (int num: num_list) {
            product = preNum * num;
            preNum = product;
        }
        answer = product < squareOfSum ? 1 : 0;
        return answer;

        //다른 풀이
        //나도 원소들의 곱을 Stream으로 구현하고 싶었는데 못했다
        /*
        *  Stream.reduce() : Stream.reduce(accumulator) 함수는 Stream의 요소들을 하나의 데이터로 만드는 작업을 수행합니다.
        *  getAsInt() : int값을 반환한다
        * */
        //Arrays.stream(numList).reduce((a, b) -> a * b).getAsInt()
    }

    //5.정수가 담긴 리스트 num_list가 주어집니다.
    //num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.
    public int day5_5(int[] num_list) {
        int answer = 0;
        String oddSum = "";
        String evenSum = "";
        for (int i : num_list) {
            if(i % 2 == 0) {
                evenSum += String.valueOf(i);
            }else {
                oddSum += String.valueOf(i);
            }
        }
        answer = Integer.parseInt(evenSum) + Integer.parseInt(oddSum);
        return answer;

        //다른풀이
        // 10을 곱해서 문제풀이
        /*
        int even = 0;
        int odd = 0;

        for(int num : num_list) {
            if(num % 2 == 0) {
                even *= 10;
                even += num;
            } else {
                odd *= 10;
                odd += num;
            }
        }
        answer = even + odd;
        */
    }
}
