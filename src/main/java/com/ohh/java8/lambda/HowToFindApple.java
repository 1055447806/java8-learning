package com.ohh.java8.lambda;

import com.ohh.java8.entity.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 如何在一堆苹果中挑选自己想要的苹果呢？
 * 挑选苹果有多种方式
 * @author Gary
 */
@SuppressWarnings("AlibabaTestClassShouldEndWithTestNaming")
public class HowToFindApple {

    /**
     * 策略模式接口
     */
    @FunctionalInterface
    public interface AppleFilter {
        /**
         * 实现过滤的具体策略
         *
         * @param apple 被过滤的苹果
         * @return 是否满足所需条件
         */
        boolean filter(Apple apple);
    }

    /**
     * 策略：过滤颜色为绿色且重量为 150 的苹果
     */
    public static class GreenAnd150WeightFilter implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return ("green".equals(apple.getColor()) && 150 == apple.getWeight());
        }
    }

    /**
     * 使用策略模式
     *
     * @param apples      所有苹果
     * @param appleFilter 苹果的过滤器
     * @return 所需的苹果
     */
    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    /**
     * 寻找绿色的苹果，颜色是硬编码
     *
     * @param apples 苹果
     * @return 绿色苹果集合
     */
    public static List<Apple> findGreenApple(List<Apple> apples) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    /**
     * 寻找任意颜色的苹果
     *
     * @param apples 苹果
     * @param color  苹果的颜色
     * @return 绿色苹果集合
     */
    public static List<Apple> findApple(List<Apple> apples, String color) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    /**
     * 测试 findGreenApple 方法
     */
    @Test
    public void findGreenApple() {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170)
        );
        List<Apple> greenApples = findGreenApple(list);
        assert greenApples.size() == 2;
        System.out.println(greenApples);
    }

    /**
     * 测试 findApple 方法
     */
    @Test
    public void findAnyColorApple() {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170)
        );
        List<Apple> greenApples = findApple(list, "green");
        List<Apple> yellowApples = findApple(list, "yellow");
        System.out.println("greenApples = " + greenApples);
        System.out.println("yellowApples = " + yellowApples);
    }

    /**
     * 使用策略模式进行实现
     */
    @Test
    public void findAppleWithStrategyPattern() {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170)
        );
        List<Apple> apples = findApple(list, new GreenAnd150WeightFilter());
        System.out.println("apples = " + apples);
    }

    /**
     * 使用匿名内部类实现策略模式
     */
    @Test
    public void findAppleWithAnonymousInnerClass() {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170)
        );
        @SuppressWarnings("Convert2Lambda")
        List<Apple> apples = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return ("yellow".equals(apple.getColor()) && 120 == apple.getWeight());
            }
        });
        System.out.println("apples = " + apples);
    }

    /**
     * 使用 lambda 表达式进行实现
     */
    @Test
    public void findAppleWithLambda() {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170)
        );
        List<Apple> apples = findApple(list, apple -> ("yellow".equals(apple.getColor()) && 120 == apple.getWeight()));
        System.out.println("apples = " + apples);
    }

    /**
     * 使用 Predicate 实现
     *
     * @param apples    所有苹果
     * @param predicate predicate 接口实现
     * @return 过滤后的结果
     */
    public List<Apple> findAppleWithPredicate(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 使用 Predicate 实现
     */
    @SuppressWarnings("DuplicatedCode")
    @Test
    public void testFindAppleWithPredicate() {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170)
        );
        List<Apple> apples = findAppleWithPredicate(list, apple -> ("yellow".equals(apple.getColor()) && 120 == apple.getWeight()));
        System.out.println("apples = " + apples);
    }
}
