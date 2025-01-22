package main.java.lambda.함수형인터페이스;

import javax.swing.text.Style;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateTest {

    /**
     * java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의
     * Predicate : 조건식을 표현하는데 사용됨. 매개변수는 하나,반환타입은 boolean (true 또는 false)
     */
    public void predicate() {
        //String 타입의 입력값을 받아 boolean값을 반환하는 함수        매개변수 -> { 함수의 본문 }
        //                                                               return문이라면 {}와 return 키워드 생략가능
        java.util.function.Predicate<String> isEmptyStr = s -> s.length() == 0;
        String s = "";

        if(isEmptyStr.test(s)) {
            System.out.println("true");
        }
    }

    public void predicate2() {
        Predicate<Integer> isSumInteger = num -> num.equals(5);
        int num = 5;

        if(isSumInteger.test(num)) {
            System.out.println("5가 맞음");
        }else {
            System.out.println("5가 아님");
        }
    }

    /***
     * 매개변수가 두개인 함수형 인터페이스 : 매개변수의 개수가 2개인 함수형 인터페이스는 이름 앞에 접두사 'Bi'가 붙는다
     *
     * BiConsumer<T,U> : 매개변수는 있지만 반환값이 없음 accept()사용
     * BiPredicat<T,U> : 매개변수가 있고 반환값이 있지만 반환이 boolean타입으로 됨(즉 true,false) 조건식에 사용 test()사용
     * BiFunction<T,U> : 매개변수를 받아서 하나의 결과를 반환 apply() 사용
     *
     */
    public void BiConsumerTest() {
        List<String> names = List.of("a" , "b", "c");
        List<Integer> ages = List.of(10,20,30);
       //Consumer<T> : Supplier와 반대로 매개변수만 있고, 반환값이 없음
        BiConsumer<String,Integer> list = (name, age) -> {
            System.out.println("namr = " + name + " age = " + age);
        };

        for (int i = 0; i < names.size(); i++) {
            list.accept(names.get(i),ages.get(i));
        }
    }
}
