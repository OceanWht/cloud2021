package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果...."+result);
        if (result == 0){
            return new CommonResult(404,"创建失败,serverPort:"+port,null);
        }

        return new CommonResult(200,"创建成功,serverPort:"+port,result);
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getById(@PathVariable("id")Long id){
        Payment payment = paymentService.getById(id);
        log.info("查询结果...."+payment);
        if (payment == null){
            return new CommonResult(404,"查询失败，查询ID："+id+"serverPort:"+port,null);
        }

        return new CommonResult(200,"查询成功，查询ID："+id+",serverPort:"+port,payment);
    }
}
