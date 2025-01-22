package main.java.lambda.함수형인터페이스;

import java.util.function.Function;
import java.util.function.Predicate;

public class Function의합성과Predicate의결합 {
    /***
     * 1. Function의 합성 : 두 람다식을 합성해서 새로운 람다식을 만들 수 있다. 두 함수의 합성은 어느 함수를 먼저 적용하느냐에 따라 달라진다
     */
    public void functionToAndThen() {
        //문자열을 숫자로 변환하는 함수f와 숫자를 2진 문자열로 변환하는 함수g를 andThend()으로 합성
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer,String> g = (i) -> Integer.toBinaryString(i);
        //즉 String타입의 값을 입력받아서 String을 결과로 반환한다.
        Function<String,String> h = f.andThen(g); //f를 먼저 실행하고 g를 실행
        System.out.println(h.apply("FF"));
    }

    public void functionToCompose() {
        //뒤에가 먼저 실행 된후, 앞이 실행
        Function<Integer,String> g = (i) -> Integer.toBinaryString(i);
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer,Integer> h = f.compose(g); //f를 먼저 실행하고 g를 실행
        System.out.println(h.apply(2));
    }

    /***
     * 2. Predicate의 결합 : 여러조건식을 논리 연산자들로 연결해서 하나의 식을 구성
     *    - and() : &&
     *    - or() : ||
     *    - negate() : !(not)
     */
    public void predicateTest() {
        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate();

        //100 <= i && (i<200 || i%2 == 0)
        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));
    }
}
