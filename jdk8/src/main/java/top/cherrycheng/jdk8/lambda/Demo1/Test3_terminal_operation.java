package top.cherrycheng.jdk8.lambda.Demo1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 最终操作会消耗流， 产生一个最终结果。
 * 也就是说， 在最终操作之后， 不能再次使用流，也不能在使用任何中间操作，否则将抛出异常
 * @author ChengRu
 * @date 2021/8/8 16:50
 * @Desc
 */
public class Test3_terminal_operation {
    public static void main(String[] args) {
//forEach来迭代流中的每个数据。
        System.out.println("---------- forEach输出了3个随机数 -----------");
 Random random = new Random();random.ints().limit(3).forEach(System.out::println);

 //count 用来统计流中的元素个数。
        System.out.println("---------- count 用来统计流中的元素个数 -----------");
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis","Hollis666", "Hello", "HelloWorld", "Hollis");
        System.out.println(strings.stream().count());//7

//collect 就是一个归约操作，可以接受各种做法作为参数，将流中的元素累积成一个汇总结果：
        System.out.println("---------- collect 就是一个归约操作 -----------");
        List<String> strings1 = Arrays.asList("Hollis", "HollisChuang", "hollis","Hollis666", "Hello", "HelloWorld", "Hollis");
        strings1 = strings1.stream().filter(string -> string.startsWith("Hollis"))
                .collect(Collectors.toList());
        System.out.println(strings1);
                //Hollis, HollisChuang, Hollis666, Hollis
    }
}
