package com.orange.demo.bigDecimalTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/21 14:19
 * @description: 该类用于测试bigDecimal
 */
public class bigDecimalTest {

    public static void main(String[] args) {
        BigDecimal badSize = new BigDecimal(12);
        BigDecimal count = new BigDecimal(500);
        BigDecimal res = badSize.divide(count, 4, RoundingMode.HALF_UP);
        System.out.println(res.toString());
    }
}
