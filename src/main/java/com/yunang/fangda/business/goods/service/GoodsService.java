package com.yunang.fangda.business.goods.service;

import com.yunang.fangda.business.goods.model.GoodsModel;
import com.yunang.fangda.utils.ResponseResult;

import java.util.List;

/**
 * Title:GoodsService<br>
 * Date:2019/3/23 10:13<br>
 * Copyright (c) 2019 Baishun<br>
 *
 * @author cxc
 */
public interface GoodsService {
    ResponseResult<List<GoodsModel>> findAllByBusId(String busid);
    ResponseResult<GoodsModel> save(GoodsModel goodsModel);
    ResponseResult<GoodsModel> delete(String uuid);
}
