package com.ohh.java8.collectors;

import com.ohh.java8.entity.Apple;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Gary
 */
@SuppressWarnings("AlibabaTestClassShouldEndWithTestNaming")
public class HelloCollector {

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
     * 找绿色苹果并输出
     */
    @Test
    public void testFindGreenApplesAndPrint() {
        List<Apple> collect = apples.stream().filter(apple -> "green".equals(apple.getColor())).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * 按颜色分组，方式一
     * 使用常规方式进行
     */
    @SuppressWarnings("Java8MapApi")
    @Test
    public void testGroupByColorWithNormalWay() {
        Map<String, List<Apple>> result = new HashMap<>();
        for (Apple apple : apples) {
            List<Apple> list = result.get(apple.getColor());
            if (list == null) {
                list = new ArrayList<>();
                result.put(apple.getColor(), list);
            }
            list.add(apple);
        }
        System.out.println(result);
    }

    /**
     * 按颜色分组，方式二
     * 使用 lambda 风格
     */
    @Test
    public void testGroupByColorWithFunctionalInterface() {
        Map<String, List<Apple>> result = new HashMap<>();
        apples.forEach(apple -> {
            List<Apple> appleList = Optional.ofNullable(result.get(apple.getColor())).orElseGet(() -> {
                List<Apple> list = new ArrayList<>();
                result.put(apple.getColor(), list);
                return list;
            });
            appleList.add(apple);
        });
        System.out.println("result = " + result);
    }

    /**
     * 按颜色分组，方式三
     * 使用 computeIfAbsent 方法
     *
     * @see Map#computeIfAbsent(Object, Function)
     */
    @Test
    public void testGroupByColorWithComputeIfAbsent() {
        Map<String, List<Apple>> result = new HashMap<>();
        for (Apple apple : apples) {
            List<Apple> list = result.computeIfAbsent(apple.getColor(), k -> new ArrayList<>());
            list.add(apple);
        }
        System.out.println(result);
    }

    /**
     * 按颜色分组，方式四
     * 使用 groupingBy 方法
     *
     * @see Collectors#groupingBy(Function)
     */
    @Test
    public void testGroupByColorWithGroupingBy(){
        Map<String, List<Apple>> collect = apples.stream().collect(Collectors.groupingBy(Apple::getColor));
        System.out.println("collect = " + collect);
    }
}
