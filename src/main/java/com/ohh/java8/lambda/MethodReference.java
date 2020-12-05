package com.ohh.java8.lambda;

import com.ohh.java8.entity.Apple;
import com.ohh.java8.entity.Apple_ThreeArgsConstructor;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 *
 * @author Gary
 */
@SuppressWarnings("AlibabaTestClassShouldEndWithTestNaming")
public class MethodReference {

    /**
     * 定义一个 Consumer 和一个 T 对象，使用 Consumer 消费 T
     *
     * @param consumer 定义一个 Consumer
     * @param t        定义一个 T
     * @param <T>      类型
     */
    @SuppressWarnings("SameParameterValue")
    private static <T> void useConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
    }

    /**
     * 使用 lambda 表达式定义 Consumer 对象
     */
    @Test
    @SuppressWarnings("Convert2MethodRef")
    public void testUseConsumerWithLambda() {
        useConsumer(s -> System.out.println(s), "Hello world");
    }

    /**
     * 使用方法引用定义 Consumer 对象
     */
    @Test
    public void testUseConsumerWithMethodReference() {
        useConsumer(System.out::println, "Hello world");
    }

    /**
     * 使用 Function 引用 Integer 的 parseInt 方法
     */
    @Test
    public void testIntegerParseInt() {
        Function<String, Integer> function = Integer::parseInt;
        Integer i = function.apply("1997");
        System.out.println("i = " + i);
    }

    /**
     * 使用 BiFunction 引用 String 的 charAt 方法
     */
    @Test
    public void testStringCharAtWithBiFunction() {
        BiFunction<String, Integer, Character> biFunction = String::charAt;
        Character c = biFunction.apply("Hello", 4);
        System.out.println("c = " + c);
    }

    /**
     * 使用 Function 引用 String 的 charAt 方法
     */
    @Test
    public void testStringCharAtWithFunction() {
        String str = "hello";
        Function<Integer, Character> function = str::charAt;
        Character c = function.apply(4);
        System.out.println("c = " + c);
    }

    /**
     * 使用 Supplier 引用 String 的构造方法
     */
    @Test
    public void testStringNew() {
        Supplier<String> supplier = String::new;
        System.out.println("supplier.get() = " + supplier.get());
    }

    /**
     * 使用 BiFunction 引用 Apple 的构造方法
     */
    @Test
    public void testAppleNew() {
        BiFunction<String, Long, Apple> biFunction = Apple::new;
        Apple apple = biFunction.apply("red", 100L);
        System.out.println("apple = " + apple);
    }

    /**
     * 使用自定义的函数式接口 ThreeFunction 引用 Apple_ThreeArgsConstructor 的构造方法
     */
    @SuppressWarnings({"AlibabaLowerCamelCaseVariableNaming","unused"})
    @Test
    public void testApple_ThreeArgsConstructorNew() {
        ThreeFunction<String, Long, String, Apple_ThreeArgsConstructor> threeFunction = Apple_ThreeArgsConstructor::new;
    }

    /**
     * 自定义的 Function 接口，接收 3 个参数，并返回结果
     *
     * @param <T> 参数 1 的类型
     * @param <K> 参数 2 的类型
     * @param <U> 参数 3 的类型
     * @param <R> 结果的类型
     */
    @FunctionalInterface
    public interface ThreeFunction<T, K, U, R> {
        /**
         * 接收 3 个参数，并返回结果
         *
         * @param t 参数 1
         * @param k 参数 2
         * @param u 参数 3
         * @return 返回的结果
         */
        @SuppressWarnings("unused")
        R apply(T t, K k, U u);
    }
}
