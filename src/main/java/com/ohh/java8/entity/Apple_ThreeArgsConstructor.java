package com.ohh.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class Apple_ThreeArgsConstructor {
    private String color;
    private Long weight;
    private String variety;
}
