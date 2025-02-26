package mordenJavaInAction.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.Attributes;

import static java.util.stream.Collectors.toList;

// 4.2 - 스트림 시작하기
public class StreamStart {
    /***
     * 스트림(Stream)이란?
     *  - 데이터 처리 연산을 지원하도록 소스에서 추출된 연속된 요소
     *  - collect를 제외한 모든 요소를 파이프라인을 형성할수 있도록 스트림을 반환한다.
     *
     *
     * 자바 8의 스트림 API의 특징
     * - 선언형 : 더 간결하고 가독성이 좋아진다.
     * - 조립할수 있다 : 유연성이 좋아진다
     * - 병렬화 : 성능이 좋아진다.
      */

    List<Dish> menu = Arrays.asList(
            new Dish("pork", false,800 , Dish.Type.MEAT),
            new Dish("beef", false,700 , Dish.Type.MEAT),
            new Dish("chicken", false,400 , Dish.Type.MEAT),
            new Dish("french fries", true,530 , Dish.Type.OTHER),
            new Dish("rice", true,350 , Dish.Type.OTHER),
            new Dish("season fruit", true,120 , Dish.Type.OTHER),
            new Dish("pizza", true,550 , Dish.Type.OTHER),
            new Dish("prawns", false,300 , Dish.Type.FISH),
            new Dish("salmon", false,450 , Dish.Type.FISH)
    );

    /***
     *  스트림 연산
     */
    public void streamStartTest() {
        List<String> threeHighCaloricDishNames =
                menu.stream() //스크림을 얻는다
                    .filter(dish -> dish.getCalories() > 300)//람다식으로 칼로리 filter
                    .map(Dish::getName) //요리이름을 추출
                    .limit(3) //상위 3개만 추출
                    .collect(toList()); //결과를 다른 리스트로 저장
        System.out.println(threeHighCaloricDishNames);
    }

    /**
     * 처음 등장하는 두 고기요리를 필터링하세요
     */
    public void streamFilterTest() {
        List<Dish> twoMeat = menu.stream()
                .filter(dish -> dish.getType().equals(Dish.Type.MEAT))
                .limit(2)
                .collect(toList());
        System.out.println(twoMeat);
    }

    /***
     * flatMap : 각 배열을 스트림이 아니라 스트림의 콘텐츠로 매핑한다 즉 하나의 평면화로 스트림을 반환한다.
     */
    public void streamFlatMapTest() {
        //숫자 리스트가 주어졌을때 각 숫자의 제곱근으로 이루어진 리스트를 반환하시오.
        //예를들어 [1,2,3,4,5]가 주어지면 [1,4,9,16,25]를 반환해야한다.
        List<Integer> numberList = Arrays.asList(1,2,3,4,5);
        List<Integer> numberCubeList = numberList.stream()
                .map(m -> m * m)
                .collect(toList());
    }

    public void streamFlatMapTest2() {
        //두개의 숫자 리스트가 있을때 모든 숫자 쌍의 리스트를 반환하시오.
        //예를 들어 두개의 리스트[1,2,3]과[3,4]가 주어지면 [(1,3),(1,4),(2,3),(2,4),(3,3),(3,4)]를 반환해야한다.
        List<Integer> numberList1 = Arrays.asList(1,2,3);
        List<Integer> numberList2 = Arrays.asList(3,4);
        List<int[]> numberList = numberList1.stream()
                .flatMap(i -> numberList2.stream()
                                                 .map(j->new int[]{i,j})
        ).collect(toList());
        System.out.println(numberList);
    }

    /**
     * 리듀싱연산 : 모든 스트림 요소를 처리해서 값으로 도출
     *           ex) 전체합, 최대.최소 구하기
     */
    public void streamReduceTest() {
        //map과 reduce메서드를 이용해서 스트림의 요리 개수를 계산하시오
        int count = menu.stream()
                .map(dish -> 1)
                .reduce(0, (a,b)->a+b); //map과 reduce를 연결하는 기법을 맵 리듀스패턴

        long count2 = menu.stream().count();

        System.out.println(count);
        System.out.println(count2);
    }



    public static void main(String[] args) {
        StreamStart streamStart = new StreamStart();
//        streamStart.streamStartTest();
//        streamStart.streamFilterTest();
//        streamStart.streamFlatMapTest2();
        streamStart.streamReduceTest();
    }
}
