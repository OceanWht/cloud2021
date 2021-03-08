package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.mapper.PaymentMapper;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.insertSelective(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
