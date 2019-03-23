package com.yunang.fangda.business.order.jpa;

import com.yunang.fangda.business.goods.model.GoodsModel;
import com.yunang.fangda.business.order.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Title:orderJpa<br>
 * Date:2019/3/22 15:52<br>
 * Copyright (c) 2019 Baishun<br>
 *
 * @author cxc
 */
public interface OrderJpa extends JpaSpecificationExecutor<OrderModel>,
        JpaRepository<OrderModel, String> {
    List<OrderModel> findByAccountIdAndBusid(String account,String accid);
    List<OrderModel> findByTypeAndBusid(String type,String accid);
}
