package main.java.lambda.함수형인터페이스;

public class main {
    public static void main(String[] args) {
        PredicateTest predicateTest = new PredicateTest();
       predicateTest.predicate2();
       predicateTest.BiConsumerTest();

        Function의합성과Predicate의결합 s = new Function의합성과Predicate의결합();
        s.functionToAndThen();
        s.functionToCompose();
        s.predicateTest();
    }
}
