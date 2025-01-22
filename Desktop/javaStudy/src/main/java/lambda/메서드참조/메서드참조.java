package main.java.lambda.메서드참조;

import java.util.function.BiFunction;
import java.util.function.Function;

public class 메서드참조 {
    /***
     * 람다식이 하나의 메서드만 호출하는경우, '메서드 참조'라는 방법으로 람다식을 간략히 할수있다.
     *
     *        <종류>                      <람다>                <메서드참조>
     * 1. static 메서드 참조 : (x) -> ClassName.method(x)  | ClassName::method
     * 2. 인스턴스메서드 참조 : (obj,x) -> obj.method(x) | ClassName::method
     * 3. 특정 객체 인스턴스메서드 참조 (x) -> obj.method(x) | obj.method
     *
     */
    public void methodReference() {
        //1. 문자열을 정수로 변환하는 람다식
        Function<String,Integer> f = (String s) -> Integer.parseInt(s); //기존
        Function<String,Integer> s = Integer::parseInt; //메서드 참조

        //2.
        BiFunction<String,String,Boolean> h = (s1,s2) -> s1.equals(s2); //기존
        BiFunction<String,String,Boolean> g = String::equals;
    }
}
