package top.cherrycheng.jdk8.lambda.Demo2;

import java.util.Arrays;
import java.util.List;

/**
 * 测试Stream与ParallelStream的区别
 * 1、Stream单线程跑的
 * 2、ParallelStream是采用多线程同步的方式运行的,所以其forEach速度极快，而其forEachOrdered作了多线程间的顺序执行，速度与stream相差不大
 * @author ChengRu
 * @date 2021/8/8 16:09
 */
public class TestStream_ParallelStream {
    public static void main(String[] args) throws InterruptedException {
//        test1();

//        testWithPrintThreadId();

        testWithThreadSleep();


    }

    private static void testWithThreadSleep() throws InterruptedException {
        System.out.println("系统一共有"+Runtime.getRuntime().availableProcessors()+"个cpu");
        System.out.println("运行结果：");
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9); /*for*/
        Long forBegin = System.currentTimeMillis();
        for (Integer number : numberList) {
            Thread.sleep(100);
        }
        System.out.println(String.format("For execute time cost %d ms", System.currentTimeMillis() - forBegin));
        System.out.println("\r"); /* stream method*/
        Long streamBegin = System.currentTimeMillis();
        numberList.stream().forEach(number -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(String.format("Stream execute time cost %d ms", System.currentTimeMillis() - streamBegin));
        System.out.println("\r"); /* parallelStream method*/
        Long parallelStreamBegin = System.currentTimeMillis();
        numberList.parallelStream().forEach(number -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(String.format("ParallelStream execute time cost %d ms", System.currentTimeMillis() - parallelStreamBegin));
        System.out.println("\r"); /* parallelStream method*/
        Long parallelStreamForEachOrderBegin = System.currentTimeMillis();
        numberList.parallelStream().forEachOrdered(number -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(String.format("ParallelStream forEachOrdered execute time cost %d ms", System.currentTimeMillis() - parallelStreamForEachOrderBegin));
    }

    private static void testWithPrintThreadId() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("运行结果：------ stream method ----------");
        numberList.stream().forEach(number -> {
            System.out.println(String.format("currentThreadId=%d,currentNumber=%d",Thread.currentThread().getId(), number));
        });
        System.out.println("\n----- parallelStream method：forEach ----------");
        numberList.parallelStream().forEach(number -> {
            System.out.println(String.format("currentThreadId=%d,currentNumber=%d",Thread.currentThread().getId(), number));
        });
        System.out.println("\n----- parallelStream method：forEachOrdered ----------");
        numberList.parallelStream().forEachOrdered(number -> {
            System.out.println(String.format("currentThreadId=%d,currentNumber=%d",Thread.currentThread().getId(), number));
        });
    }

    private static void test1() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("运行结果：------ stream method ----------");
        numberList.stream().forEach(number -> {
            System.out.print(String.format("%d ", number));
        });
        System.out.println("\n----- parallelStream method：forEach ----------");
        numberList.parallelStream().forEach(number -> {
            System.out.print(String.format("%d ", number));
        });
        System.out.println("\n----- parallelStream method：forEachOrdered ----------");
        numberList.parallelStream().forEachOrdered(number -> {
            System.out.print(String.format("%d ", number));
        });
    }
}
