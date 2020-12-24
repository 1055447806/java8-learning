package com.ohh.java8.collectors;

import com.ohh.java8.entity.Apple;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Gary
 */
@SuppressWarnings("AlibabaTestClassShouldEndWithTestNaming")
public class CollectorsApi {

    /**
     * 一堆苹果
     */
    private static List<Apple> apples = Arrays.asList(
            new Apple("yellow", 120),
            new Apple("green", 170),
            new Apple("green", 150),
            new Apple("yellow", 120),
            new Apple("green", 170)
    );

    /**
     * 计算平均重量
     *
     * @see Collectors#averagingDouble(ToDoubleFunction) 对 double 类型求平均值
     */
    @Test
    public void testAveragingDouble() {
        double averagingWeight = apples.stream().collect(Collectors.averagingDouble(Apple::getWeight));
        System.out.println("averagingWeight = " + averagingWeight);
    }

    /**
     * 计算平均重量
     *
     * @see Collectors#averagingInt(ToIntFunction) 对 int 类型求平均值
     */
    @Test
    public void testAveragingInt() {
        double averagingWeight = apples.stream().collect(Collectors.averagingInt(apple -> (int) apple.getWeight()));
        System.out.println("averagingWeight = " + averagingWeight);
    }

    /**
     * 计算平均重量
     *
     * @see Collectors#averagingLong(ToLongFunction) 对 long 类型求平均值
     */
    @Test
    public void testAveragingLong() {
        double averagingWeight = apples.stream().collect(Collectors.averagingLong(apple -> (long) apple.getWeight()));
        System.out.println("averagingWeight = " + averagingWeight);
    }

    /**
     * 计算平均重量，以字符串返回
     *
     * @see Collectors#collectingAndThen(Collector, Function)
     */
    @Test
    public void testCollectingAndThen() {
        String average = apples.stream().collect(Collectors.collectingAndThen(Collectors.averagingDouble(Apple::getWeight), String::valueOf));
        System.out.println("average = " + average);
    }

    /**
     * 使用 collectingAndThen 方法使返回的 List 不可修改
     *
     * @see Collectors#collectingAndThen(Collector, Function)
     * @see Collections#unmodifiableList(List)
     */
    @Test
    public void testCollectingAndThenToUnmodifiableList() {
        List<Apple> appleList = apples.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        try {
            appleList.add(new Apple());
        } catch (Exception e) {
            System.err.println(e.getClass());
        }
    }

    // 19 集 16 分
}
