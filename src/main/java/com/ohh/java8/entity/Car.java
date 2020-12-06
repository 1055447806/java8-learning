package com.ohh.java8.entity;

import lombok.Data;

import java.util.Optional;

/**
 * @author Gary
 */
@Data
public class Car {
    private Optional<Insurance> insurance;
}
