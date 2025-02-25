package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

//수강신청
public class CourseRegistration13414 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> hashSet = new LinkedHashSet<>();

        for(int i = 0 ; i < len ; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (hashSet.contains(str)) { //두번 중복을 눌렀을경우
                hashSet.remove(str);
            }
            hashSet.add(str);
        }

        Iterator iter = hashSet.iterator();	// Iterator 사용
        int count = 0;
        while (iter.hasNext() && count < k) {
            System.out.println(iter.next());
            count++;
        }
    }
}
