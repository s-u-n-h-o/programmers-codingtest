package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//카드게임2
public class CardGame10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        //카드의 개수만큼 반복
        for (int i = 0; i < number; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            }else {
                hashMap.put(key, 1);
            }
        }

        int numberInteger = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberInteger; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(hashMap.getOrDefault(key, 0) + " ");
        }
        System.out.print(sb.toString());
    }
}
