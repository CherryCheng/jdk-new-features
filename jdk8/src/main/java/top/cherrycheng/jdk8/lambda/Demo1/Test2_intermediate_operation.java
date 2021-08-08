package top.cherrycheng.jdk8.lambda.Demo1;

import java.util.Arrays;
import java.util.List;

/**
 * Stream里一些典型的中间操作
 * @author ChengRu
 * @date 2021/8/8 16:33
 * @Desc
 */
public class Test2_intermediate_operation {
    public static void main(String[] args) {
//filter通过设置的条件过滤出元素。
        System.out.println("----------以下代码过滤掉空字符串-----------");
        List<String> strings = Arrays.asList("Hollis", "", "HollisChuang", "H", "hollis");
        strings.stream().filter(string -> !string.isEmpty()).forEach(System.out::println);
//map 方法用于映射每个元素到对应的结果
        System.out.println("\n----------以下代码输出了元素对应的平方数-----------");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().map( i -> i*i).forEach(System.out::println);
//limit/skip,limit返回前面n个元素；skip是扔掉前n个元素。
        List<Integer> numbers1 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        System.out.println("\n----------limit返回前面4个元素-----------");
        numbers1.stream().limit(4).forEach(System.out::println);
        System.out.println("\n----------skip是扔掉前4个元素-----------");
        numbers1.stream().skip(4).forEach(System.out::println);
//sorted 方法用于对流进行排序。
        System.out.println("\n----------以下代码片段使用 sorted 方法进行排序-----------");
        List<Integer> numbers3 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers3.stream().sorted().forEach(System.out::println);
//distinct 主要用来去重，
        System.out.println("\n----------以下代码片段使用 distinct 对元素进行去重-----------");
        List<Integer> numbers4 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers4.stream().distinct().forEach(System.out::println);

//联合使用
        List<String> strings1 = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        strings1.stream().filter(string -> string.length() <= 6).map(String::length).sorted().limit(3).distinct().forEach(a -> System.out.println("结果为：" + a));
    }
}
