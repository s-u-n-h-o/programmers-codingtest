package com.example.codingTest_all;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//방문 길이
public class PathLength {

    /***
     * 1차 시도 -> 실패
     *         - 좌표의 위치가 같다고 생각하고 풀었음
     *         - 좌표의 위치가 같은게 아니라 길의 방향이 같은지 확인해야한다
     * @param dirs
     * @return
     */
    public int solution(String dirs) {
        int rigth = 0;
        int left =0;
        int plusLength = 0;

        HashMap<List<Integer> , String> length = new HashMap();
        String[] directions = dirs.split("");
        for (String dir : directions) {
            switch (dir) {
                case "U" -> left++;
                case "R" -> rigth++;
                case "D" -> left--;
                case "L" -> rigth--;
            }
            if(left > 5 || left < -5 || rigth > 5 || rigth < -5 ) {
                if(dir.equals("U")){left--;}
                if(dir.equals("R")){rigth--;}
                if(dir.equals("D")){left++;}
                if(dir.equals("L")){rigth++;}
                continue;
            }
            if(length.containsKey(Arrays.asList(rigth,left)) && length.get(Arrays.asList(rigth,left)).equals(dir)) { //중복값이 있을때
                continue;
            } else if(length.containsKey(Arrays.asList(rigth,left)) && !length.get(Arrays.asList(rigth,left)).equals(dir)){
                plusLength++;
            }
            if(rigth == 0 && left == 0) {
                continue;
            }

            length.put(Arrays.asList(rigth,left), dir);
        }
        return length.size() + plusLength;
    }

    /**
     * 현재위치 - 다음위치
     * 다음위치 - 현재위치
     * 이렇게 두가지를 확인해야 길의 방향이 동일한지 확인할수있다.
     * @param dirs
     * @return
     */
    public int solution2(String dirs) {
        //현재 위치 체크하는 값
        int x = 0;
        int y = 0;
        HashSet<String> hashSet = new HashSet();

        for (String dir : dirs.split("")) {
            //다음위치 체크하는 값
            int nx = x, ny = y;

            switch (dir) {
                case "U" -> ny++;
                case "D" -> ny--;
                case "R" -> nx++;
                case "L" -> nx--;
            }
            if(nx > 5 || nx < -5 || ny > 5 || ny < -5 ) { //범위에서 벗어난것들 확인
                continue;
            }

            String path1 = x +"," +y + "->" + nx+"," +ny; //현재위치 - 다음위치
            String path2 = nx+"," +ny + "->" + x+"," +y; //다음위치 - 현재위치
            hashSet.add(path1);
            hashSet.add(path2);

            /***
             *
               순서	    입력	현재 좌표 (x, y)	      이동한 길 (경로)
             [1]	U	    (0,0) → (0,1)	        "0,0->0,1", "0,1->0,0"
             [2]	L	    (0,1) → (-1,1)	        "-1,1->0,1", "0,1->-1,1"
             [3]	U	    (-1,1) → (-1,2)	        "-1,1->-1,2", "-1,2->-1,1"
             [4]	R	    (-1,2) → (0,2)	        "-1,2->0,2", "0,2->-1,2"
             [5]	R	    (0,2) → (1,2)	        "0,2->1,2", "1,2->0,2"
             [6]	D	    (1,2) → (1,1)	        "1,2->1,1", "1,1->1,2"
             [7]	L	    (1,1) → (0,1)	        "1,1->0,1", "0,1->1,1"
             [8]	L	    (0,1) → (-1,1)	        이미 방문한 길 → 무시됨
             [9]	U	    (-1,1) → (-1,2)	        이미 방문한 길 → 무시됨
             */

            x = nx;
            y = ny;
        }
        return hashSet.size() / 2;
    }

    public static void main(String[] args) {
        PathLength pathLength = new PathLength();
//        pathLength.solution("ULURRDLLU");
//        pathLength.solution("LULLLLLLU");
//        pathLength.solution("URULDD");

        pathLength.solution2("ULURRDLLU");
//        pathLength.solution("LULLLLLLU");
//        pathLength.solution("URULDD");
    }
}
