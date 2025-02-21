package com.example.codingTest_ScoreBooster.hash;

import java.util.*;

import static java.lang.Integer.sum;

public class BestAlbum {


    /**
     *
     * @param genres 노래의 장르
     * @param plays 장르 내에서 많이 재생된 횟수
     * @return
     */
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        String tmp = "";
        int count = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();

        //1. 각 장르별로 분류
        for (int i = 0; i < genres.length; i++) {
            hashMap.put(genres[i], hashMap.getOrDefault(genres[i],0) + plays[i]);
        }
        ArrayList<String> arr = new ArrayList<>();
        for (String s : hashMap.keySet()) {
            arr.add(s);
        }
        arr.sort((a,b) -> hashMap.get(b) - hashMap.get(a));

        return answer;
    }

    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();
        bestAlbum.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
}
