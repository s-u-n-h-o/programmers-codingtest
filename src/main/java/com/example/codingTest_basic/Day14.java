package com.example.codingTest;

public class Day14 {

//    정수 리스트 num_list가 주어집니다. 가장 첫 번째 원소를 1번 원소라고 할 때,
//    홀수 번째 원소들의 합과 짝수 번째 원소들의 합 중 큰 값을 return 하도록 solution 함수를 완성해주세요. 두 값이 같을 경우 그 값을 return합니다.
    public int day14_1(int[] num_list, int[][] ints) {
        int oddSum = 0;
        int evenSum = 0;

        for(int i = 0 ; i < num_list.length ; i++ ) {
            if(i % 2 == 0) { //홀수번
                oddSum += num_list[i];
            }else { //짝수번
                evenSum += num_list[i];
            }
        }

        int answer = Math.max(oddSum, evenSum);
        return answer;
    }

    //2.최대 5명씩 탑승가능한 놀이기구를 타기 위해 줄을 서있는 사람들의 이름이 담긴 문자열 리스트 names가 주어질 때,
    // 앞에서 부터 5명씩 묶은 그룹의 가장 앞에 서있는 사람들의 이름을 담은 리스트를 return하도록 solution 함수를 완성해주세요.
    // 마지막 그룹이 5명이 되지 않더라도 가장 앞에 있는 사람의 이름을 포함합니다.
    public String[] day14_2(String[] names) {
        int cnt = 0;
        int totalLen = names.length % 5 == 0 ? names.length / 5 : (names.length / 5) + 1;
        String[] answer = new String[totalLen];

        //5의 배수만 담아서 리턴하면된다.
        for(int i = 0 ; i < totalLen;) {
            answer[cnt] = names[5 *i];
            i++;
            cnt++;
        }
        return answer;
    }

    //3. 오늘 해야 할 일이 담긴 문자열 배열 todo_list와 각각의 일을 지금 마쳤는지를 나타내는 boolean 배열 finished가 매개변수로 주어질 때,
    // todo_list에서 아직 마치지 못한 일들을 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
    public String[] day14_3(String[] todo_list, boolean[] finished) {
        int cnt = 0;
        int j = 0;
        for(boolean b : finished) {
            if(b == false) {cnt++;}
        }
        String[] answer = new String[cnt];

        for(int i = 0 ; i < todo_list.length ; i++) {
            if(finished[i] == false) {
                answer[j++] = todo_list[i];
            }
        }
        return answer;

        //다른 풀이
        //나는 무조건 배열의 길이를 알아서 배열의 공간을 만든다음에 하려고 했는데
        //다른 사람의 풀이를 보니까 String으로 쭉 받아서 나중에 배열로 잘라냈다! 이렇게 할수있는것이 신기했다.
//        String blankStr = ""; //1. 공백을 선언한다
//        for(int i = 0 ; i < finished.length; i++) {
//            blankStr = finished[i] == false ? blankStr + todo_list[i] + "," : blankStr; //false면 할일에 추가하고 아니면 그냥 넣는다
//        }
//        return blankStr.split(",");
    }

    //4.정수 배열 numbers와 정수 n이 매개변수로 주어집니다.
    // numbers의 원소를 앞에서부터 하나씩 더하다가 그 합이 n보다 커지는 순간 이때까지 더했던 원소들의 합을 return 하는 solution 함수를 작성해 주세요.
    public int[] day14_4(int[] arr, int[][] queries) {
        int st = 0;
        int ed = 0;

        for(int i = 0 ; i < queries.length ; i++) {
            st = queries[i][0];
            ed = queries[i][1];
            for(int j = st ; j <= ed ; j++) {
                arr[j] = arr[j] + 1;
            }
        }
        return arr;
    }
}
