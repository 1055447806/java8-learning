package com.ohh.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Optional;

/**
 * Stream 的使用
 *
 * @author Gary
 */
@SuppressWarnings("AlibabaTestClassShouldEndWithTestNaming")
public class HowToUseStream {

    /**
     * 将多个字符串中的重复字母去重
     *
     * @see Stream#distinct()
     * @see Stream#flatMap(Function)
     */
    @Test
    public void testDistinctAndFlatMap() {
        String[] words = {"Hello", "World"};
        Arrays.stream(words)
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 测试 Stream 的 match 方法
     *
     * @see Stream#anyMatch(Predicate)
     * @see Stream#allMatch(Predicate)
     * @see Stream#noneMatch(Predicate)
     */
    @Test
    public void testMatches() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        boolean anyMatch = Arrays.stream(ints).anyMatch(i -> i > 6);
        System.out.println("anyMatch > 6 = " + anyMatch);
        boolean allMatch = Arrays.stream(ints).allMatch(i -> i > 10);
        System.out.println("allMatch > 10 = " + allMatch);
        boolean noneMatch = Arrays.stream(ints).noneMatch(i -> i < 0);
        System.out.println("noneMatch < 0 = " + noneMatch);
    }

    /**
     * 在一组数组中寻找符合条件的值，如果存在，打印值，如果不存在，打印 -1
     *
     * @see Stream#filter(Predicate)
     * @see Stream#findAny()
     * @see Optional#orElse(Object)
     */
    @Test
    public void testFilterAndFindAny() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        int result = Arrays.stream(ints).filter(i -> i > 100).findAny().orElse(-1);
        System.out.println("result = " + result);
    }

    /**
     * 数组元素求和输出
     *
     * @see Stream#reduce(BinaryOperator)
     * @see Stream#reduce(Object, BinaryOperator)
     */
    @Test
    public void testReduce() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        Arrays.stream(ints).reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println(Arrays.stream(ints).reduce(100, Integer::sum));
    }

    /**
     * Stream 转换为 IntStream，并求和
     *
     * @see Stream#mapToInt(ToIntFunction)
     */
    @Test
    public void testStreamToIntStream() {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7};
        IntStream intStream = Arrays.stream(integers).mapToInt(Integer::intValue);
        System.out.println("intStream.sum() = " + intStream.sum());
    }

    /**
     * IntStream 转换为 Stream，并遍历结果
     *
     * @see IntStream#boxed()
     */
    @Test
    public void testIntStreamToStream() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        Stream<Integer> stream = Arrays.stream(ints).boxed();
        stream.forEach(System.out::println);
    }

    /**
     * 测试 IntStream 的 rangeClose 方法
     *
     * @see IntStream#rangeClosed(int, int)
     */
    @Test
    public void testRangeClosed() {
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
    }
}
