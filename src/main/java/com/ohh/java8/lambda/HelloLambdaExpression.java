package com.ohh.java8.lambda;

import com.ohh.java8.entity.Apple;
import org.junit.Test;

import java.util.Comparator;

/**
 * 创建 Comparator 的几种方式
 *
 * @author Gary
 */

@SuppressWarnings("AlibabaTestClassShouldEndWithTestNaming")
public class HelloLambdaExpression {

    /**
     * 使用匿名内部类
     */
    @Test
    @SuppressWarnings("All")
    public void createWithAnonymousInnerClass() {
        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };
    }

    /**
     * 使用 lambda 表达式
     */
    @Test
    @SuppressWarnings("All")
    public void createWithLambda() {
        Comparator<Apple> byColor2 = ((o1, o2) -> o1.getColor().compareTo(o2.getColor()));
    }

    /**
     * 使用方法引用
     */
    @Test
    @SuppressWarnings("unused")
    public void createWithMethodReference() {
        Comparator<Apple> byColor2 = (Comparator.comparing(Apple::getColor));
    }
}
