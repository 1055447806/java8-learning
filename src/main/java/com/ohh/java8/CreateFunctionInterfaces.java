package com.ohh.java8;

import org.junit.Test;

import java.util.function.*;

/**
 * 几种函数式接口
 *
 * @author Gary
 */
public class CreateFunctionInterfaces {

    /**
     * Function
     */
    @Test
    @SuppressWarnings("All")
    public void createFunction() {
        Function<String, Integer> function = s -> s.length();
    }

    /**
     * Predicate
     */
    @Test
    @SuppressWarnings("unused")
    public void createPredicate() {
        Predicate<Apple> predicate = apple -> "green".equals(apple.getColor());
    }


    /**
     * BiPredicate
     */
    @Test
    @SuppressWarnings("unused")
    public void createBiPredicate() {
        BiPredicate<String, Long> biPredicate = (color, weight) -> "green".equals(color) && 150 == weight;
    }

    /**
     * Consumer
     */
    @Test
    @SuppressWarnings({"unused"})
    public void createConsumer() {
        Consumer<Apple> consumer = apple -> System.out.println(apple.getClass());
    }

    /**
     * BiConsumer
     */
    @Test
    @SuppressWarnings("unused")
    public void testBiConsumer() {
        BiConsumer<String, Long> biConsumer = (color, weight) -> System.out.printf("color: %s, weight: %s", color, weight);
    }

    /**
     * IntFunction
     */
    @Test
    @SuppressWarnings("unused")
    public void createIntFunction() {
        IntFunction<Double> intFunction = i -> i * 100.0d;
    }

    /**
     * BiFunction
     */
    @Test
    @SuppressWarnings("unused")
    public void createBiFunction() {
        BiFunction<String, Long, Apple> biFunction = Apple::new;
    }

    /**
     * Supplier
     */
    @Test
    @SuppressWarnings("unused")
    public void createSupplier() {
        Supplier<Apple> supplier = Apple::new;
    }
}
