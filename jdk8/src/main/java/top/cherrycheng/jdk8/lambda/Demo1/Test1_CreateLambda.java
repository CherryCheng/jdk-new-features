package top.cherrycheng.jdk8.lambda.Demo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream三步走：
 * 1、创建 2、中间操作（intermediate operation） 3、最终操作(terminal operation)
 * @author ChengRu
 * @date 2021/8/8 15:59
 * @Desc
 */
public class Test1_CreateLambda {
    public static void main(String[] args) {
//        1、通过集体创建
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        Stream<String> stream = strings.stream();
//        2、直接用流创建
        Stream.of(3, 1, 8, 7).forEach(a -> System.out.println(a));

        System.out.println("----------------");
        //        也可直接创建多线程专用的流：注意这里forEachOrdered是指数组原有顺序，不是给你排序，因为它是多线程打的，直接forEach会乱序
        Arrays.asList(1,2,3,4,5,6).parallelStream().forEach(a-> System.out.println(a));
        System.out.println("----------------");
        Arrays.asList(1,2,3,4,5,6).parallelStream().forEachOrdered(a-> System.out.println(a));
    }
}
