package com.chenguangli.base.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenguangli
 * @date 2019/4/24 23:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    private String name;
    private double money;
    private int year;
    private int month;
    private int day;
}
