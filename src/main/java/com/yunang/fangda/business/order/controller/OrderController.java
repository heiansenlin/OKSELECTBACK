package com.yunang.fangda.business.order.controller;

import com.yunang.fangda.business.goods.model.GoodsModel;
import com.yunang.fangda.business.order.model.OrderModel;
import com.yunang.fangda.business.order.service.OrderService;
import com.yunang.fangda.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Title:OrderController<br>
 * Date:2019/3/22 11:00<br>
 * Copyright (c) 2019 Baishun<br>
 *
 * @author cxc
 */
@Api(value = "订单接口",description = "订单接口")
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service;
    /**
	 * 增
	 * @author cxc
	 * @return
	 * @date 2019/3/22 16:05
	 * @exception
	 */
	@ApiOperation("增加订单")
	@RequestMapping(value = "/order",method = RequestMethod.POST)
	public ResponseResult<OrderModel> save(
			@ApiParam(value = "订单实体类",required = true,example = "订单实体类")
			@RequestBody OrderModel orderModel,HttpServletRequest request){
		return service.save(orderModel,request);
	}

    /**
	 * 删
	 * @author cxc
	 * @return
	 * @date 2019/3/22 16:05
	 * @exception
	 */
	@ApiOperation("删除订单")
	@RequestMapping(value = "/order/{uuid}",method = RequestMethod.DELETE)
	public ResponseResult<OrderModel> delete(
			@ApiParam(value = "订单主键",required = true,example = "订单主键")
			@PathVariable("uuid") String uuid){
		return service.delete(uuid);
	}

    /**
	 * 改
	 * @author cxc
	 * @return
	 * @date 2019/3/22 16:05
	 * @exception
	 */

    /**
	 * 查-根据客户手机号码
	 * @author cxc
	 * @return
	 * @date 2019/3/22 16:06
	 * @exception
	 */
    @ApiOperation("根据客户手机号码查询订单")
	@RequestMapping(value = "/findAllByPhone/{phone}",method = RequestMethod.GET)
    public ResponseResult<List<OrderModel>> findAllByPhone(
			@ApiParam(value = "电话号码",required = true,example = "18032135459")
    		@PathVariable("phone") String phone, HttpServletRequest request){
    	return service.findAllByPhone(phone,request);
	}

	/**
	 * 查-查询所有完成或未完成订单
	 * @author cxc
	 * @return
	 * @date 2019/3/22 16:06
	 * @exception
	 */
	@ApiOperation("查询所有完成或未完成订单")
	@RequestMapping(value = "/findAllByType/{type}",method = RequestMethod.GET)
	public ResponseResult<List<OrderModel>> findAllByType(
			@ApiParam(value = "状订单态",required = true,example = "0:未完成，1：已完成，2：已关闭")
			@PathVariable("type") String type, HttpServletRequest request){
		return service.findAllByType(type,request);
	}
}
