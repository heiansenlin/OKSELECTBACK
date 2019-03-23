package com.yunang.fangda.business.order.service;

import com.yunang.fangda.business.order.model.OrderModel;
import com.yunang.fangda.utils.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Title:orderService<br>
 * Date:2019/3/22 15:49<br>
 * Copyright (c) 2019 Baishun<br>
 *
 * @author cxc
 */
public interface OrderService {
    ResponseResult<OrderModel> save(OrderModel orderModel,HttpServletRequest request);
    ResponseResult<OrderModel> delete(String uuid);
    ResponseResult<List<OrderModel>> findAllByPhone(String phone, HttpServletRequest request);
    ResponseResult<List<OrderModel>> findAllByType(String type, HttpServletRequest request);
}
