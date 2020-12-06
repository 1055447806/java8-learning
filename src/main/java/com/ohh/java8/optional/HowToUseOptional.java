package com.ohh.java8.optional;

import com.ohh.java8.entity.Car;
import com.ohh.java8.entity.Insurance;
import com.ohh.java8.entity.Person;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author Gary
 */
@SuppressWarnings("AlibabaTestClassShouldEndWithTestNaming")
public class HowToUseOptional {

    /**
     * Optional 的 flatMap 方法会把 Function 返回的新 Optional 作为结果
     *
     * @see Optional#flatMap(Function)
     */
    public String getInsuranceName(Person person) {
        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .flatMap(Insurance::getName)
                .orElse("empty insurance.");
    }

    /**
     * 测试 getInsuranceName 方法
     */
    @Test
    public void testGetInsuranceName() {
        System.out.println("getInsuranceName(null) = " + getInsuranceName(null));
    }
}
