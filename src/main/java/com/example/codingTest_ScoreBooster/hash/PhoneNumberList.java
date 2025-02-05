package com.example.codingTest_ScoreBooster.hash;

import java.util.Arrays;
public class PhoneNumberList {

    /***
     * 문제점1 : 포함을 확인하려고 contains()를 사용해서 문제를 풀었음 하지만 해당 문제는 접두어를 확인하는것이기때문에 사용하는데 좋지않다.
     * 문제점2 : 중간의 값이 접두어가 될수도 있으니까 전부 하나씩 비교해주기위해서 이중 for문을 써서 풀었는데 이렇게 하니까 효율성에서 통과가 안되었다.
     *
     * 배운 것 : startsWith(String prefix) : 앞 문자열이 뒷 문자열의 접두어인지 확인한다.
     * @param phone_book
     * @return
     */
    public boolean solution(String[] phone_book) {
        //배열을 정리해서 가장 짧은순으로 정렬하면 문제점2번이 한번에 해결된다.
        //ex) "12","123","1235","567","88"
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) { //배열의 길이 -1을 하는 이유는
            //startsWith을 사용하면 해당 문자열로 시작하는지 확인할수있다.
            //phone_book[i + 1].startsWith(phone_book[i]) 하면 "123"이 "12"에 접두어인가?를 확인할수있다.
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       PhoneNumberList phoneNumberList = new PhoneNumberList();
       phoneNumberList.solution(new String[]{"119", "97674223", "1195524421"}); //false
       //phoneNumberList.solution(new String[]{"123","456","789"}); //true
       //phoneNumberList.solution(new String[]{"12","123","1235","567","88"}); //false
    }
}
