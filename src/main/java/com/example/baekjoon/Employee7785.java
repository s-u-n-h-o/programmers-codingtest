package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 7785 - 회사에 있는사람
public class Employee7785 {
    //사람들이 출근했는지 퇴근했는지 확인해서 출근한사람만 출력

    //첫줄이 총 몇명인지
    //이름이 중복되는것은 없음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> hashSet = new HashSet<>();

        int total = Integer.parseInt(st.nextToken());

        //사람의 이름을 key값으로, 출근했는지 퇴근했는지를 확인후 퇴근했다면 key값 삭제하기
        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();
            //출근(enter)시 추가 퇴근(leave)시 삭제
            if(value.equals("enter")) {
                hashSet.add(key);
            } else if (value.equals("leave")) {
                hashSet.remove(key);
            }
        }
        ArrayList<String> arrayList = new ArrayList<>(hashSet);
        //Collections.reverse(arrayList); 틀림 => 회사에 남아있는 사람을 역순으 출력해야하는데 이건 입력순서에서만 역순일뿐이다, 사전 역순이 필요
        arrayList.sort(Collections.reverseOrder());
        arrayList.forEach(System.out::println);
    }
}
