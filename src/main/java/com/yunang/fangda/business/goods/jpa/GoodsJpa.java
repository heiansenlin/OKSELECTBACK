package com.yunang.fangda.business.goods.jpa;

import com.yunang.fangda.business.goods.model.GoodsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Title:GoodsJpa<br>
 * Date:2019/3/23 10:22<br>
 * Copyright (c) 2019 Baishun<br>
 *
 * @author cxc
 */
public interface GoodsJpa extends JpaSpecificationExecutor<GoodsModel>,
        JpaRepository<GoodsModel, String> {
    List<GoodsModel> findByBusid(String busid);

}
