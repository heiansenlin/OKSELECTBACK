package com.yunang.fangda.business.order.service.serviceImpl;

import com.yunang.fangda.business.account.model.AccountModel;
import com.yunang.fangda.business.account.service.AccountService;
import com.yunang.fangda.business.order.jpa.OrderJpa;
import com.yunang.fangda.business.order.model.OrderModel;
import com.yunang.fangda.business.order.service.OrderService;
import com.yunang.fangda.sys.shiro.JWTUtils;
import com.yunang.fangda.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Title:orderServiceImpl<br>
 * Date:2019/3/22 15:49<br>
 * Copyright (c) 2019 Baishun<br>
 *
 * @author cxc
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderJpa jpa;
    @Autowired
    private AccountService accountService;
    @Override
    public ResponseResult<OrderModel> save(OrderModel orderModel,HttpServletRequest request) {
        if (StringUtils.isEmpty(orderModel)||orderModel==null){
            return new ResponseResult<>(false,"订单不可为空",null);
        }else {
            String accId = JWTUtils.getAccId(request);
            orderModel.setBusid(accId);
            OrderModel save = jpa.save(orderModel);
            return new ResponseResult<>(true,"成功",save);
        }
    }

    @Override
    public ResponseResult<OrderModel> delete(String uuid) {
        if (uuid == null || uuid.isEmpty())
            return new ResponseResult<>(false, "删除条件不能为空", null);
        jpa.deleteById(uuid);
        return new ResponseResult<>(true, "成功", null);
    }

    @Override
    public ResponseResult<List<OrderModel>> findAllByPhone(String phone, HttpServletRequest request) {
        String accId = JWTUtils.getAccId(request);
        if (StringUtils.isEmpty(phone)&&phone==null){
            return new ResponseResult<>(false, "查询条件不能为空", null);
        }else {
            ResponseResult<AccountModel> oneByPhone = accountService.getOneByPhone(phone);
            if (StringUtils.isEmpty(oneByPhone.getData()))
                return new ResponseResult<>(false, "该用户未查询到", null);
            String account = oneByPhone.getData().getAccount();
            List<OrderModel> byAccountAndBusid = jpa.findByAccountAndBusid(account, accId);
            if (byAccountAndBusid.size()<=0){
                return new ResponseResult<>(false, "未查询到订单", null);
            }else {
                return new ResponseResult<>(true, "成功", byAccountAndBusid);
            }
        }
    }

    @Override
    public ResponseResult<List<OrderModel>> findAllByType(String type, HttpServletRequest request) {
        String accId = JWTUtils.getAccId(request);
        if (StringUtils.isEmpty(type)&&type==null){
            return new ResponseResult<>(false, "查询条件不能为空", null);
        }else {
            List<OrderModel> byTypeAndBusid = jpa.findByTypeAndBusid(type, accId);
            if (byTypeAndBusid.size()<=0){
                return new ResponseResult<>(false, "未查询到订单", null);
            }else {
                return new ResponseResult<>(true, "成功", byTypeAndBusid);
            }
        }
    }
}
