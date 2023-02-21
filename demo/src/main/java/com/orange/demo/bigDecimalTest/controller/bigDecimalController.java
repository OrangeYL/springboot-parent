package com.orange.demo.bigDecimalTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/21 14:34
 * @description:
 */
@RestController
@RequestMapping("/cal")
public class bigDecimalController {

    /**
     * BigDecimal使用divide除法，如果能除尽，如12/500 = 0.024，此时若想保留4位小数，对于单个计算来说没问题（如calSingle方法）
     * 如果是多个计算存进List中，就会不起作用（如calList方法），此时可以考虑先转为String,再存进链表里（如cal方法）。
     **/

    @GetMapping("/list")
    public List<BigDecimal> calList(){
        List<BigDecimal> list = new ArrayList<>();
        BigDecimal badSize = new BigDecimal(12);
        BigDecimal count = new BigDecimal(500);
        BigDecimal res = null;
        for(int i = 0;i < 5;i++){
            res = badSize.divide(count,4,RoundingMode.HALF_UP);
            list.add(res);
        }
        return list;
        //返回	0.024,0.024,0.024,0.024,0.024
    }
    @GetMapping("/listStr")
    public List<String> cal(){
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");
        List<String> list = new ArrayList<>();
        BigDecimal badSize = new BigDecimal(12);
        BigDecimal count = new BigDecimal(500);
        BigDecimal res = null;
        for(int i = 0;i < 5;i++){
            res = badSize.divide(count, 4, RoundingMode.HALF_UP);
            String s = decimalFormat.format(res);
            list.add(s);
        }
        return list;
        //返回"0.0240","0.0240","0.0240","0.0240","0.0240"
    }
}
