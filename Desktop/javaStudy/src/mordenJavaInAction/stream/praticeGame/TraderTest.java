package mordenJavaInAction.stream.praticeGame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class TraderTest {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactionList = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    /***
     * 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오
     */
    public void practice1(){
        List<Transaction> transactions = transactionList.stream()
                .filter(i -> i.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(transactions);
    }

    /**
     * 2. 거래자가 근무하는 모든 도시를 중복없이 나열하시오.
     */
    public void practice2() {
        List<String> cityList = transactionList.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println(cityList);
    }

    /**
     * 3. 케임브릿지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
     */
    public void practice3() {
        List<Trader> nameList = transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());
        System.out.println(nameList);
    }

    /**
     * 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
     */
    public void practice4() {
        String nameList = transactionList.stream()
                .map(Transaction -> Transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1,n2) -> n1+n2);

        System.out.println(nameList);
    }

    /**
     * 5. 밀라노에 거래자가 있는가?
     */
    public void practice5() {
        boolean checkMilan = transactionList.stream()
                .anyMatch(i->i.getTrader().getCity().equals("Milan"));
        System.out.println(checkMilan);
    }

    /**
     * 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
     */
    public void practice6() {
        List<Integer> numberList = transactionList.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getValue())
                .collect(toList());
        System.out.println(numberList);
    }

    /**
     * 7. 전체 트랜잭션 중 최댓값은 얼마인가?
     */
    public void practice7() {
        Optional<Integer> maxNumber = transactionList.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max);
        System.out.println(maxNumber);
    }

    /**
     * 8. 전체 트랜젝션 중 최솟값은 얼마인가?
     */
    public void practice8() {
        Optional<Integer> minNumber = transactionList.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::min);

        Optional<Transaction> minNumber2 = transactionList.stream()
                        .min(Comparator.comparing(Transaction::getValue));
        System.out.println(minNumber);
        System.out.println(minNumber2);
    }


    public static void main(String[] args) {
        TraderTest t = new TraderTest();
        t.practice1();
        t.practice2();
        t.practice3();
        t.practice4();
        t.practice5();
        t.practice6();
        t.practice7();
        t.practice8();
    }
}
