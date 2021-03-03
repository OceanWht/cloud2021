package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果...."+result);
        if (result == 0){
            return new CommonResult(404,"创建失败",null);
        }

        return new CommonResult(200,"创建成功",result);
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getById(@PathVariable("id")Long id){
        Payment payment = paymentService.getById(id);
        log.info("查询结果...."+payment);
        if (payment == null){
            return new CommonResult(404,"查询失败",null);
        }

        return new CommonResult(200,"查询成功，查询ID："+id,payment);
    }
}
