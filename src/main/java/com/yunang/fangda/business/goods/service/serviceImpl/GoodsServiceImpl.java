package com.yunang.fangda.business.goods.service.serviceImpl;

import com.yunang.fangda.business.goods.jpa.GoodsJpa;
import com.yunang.fangda.business.goods.model.GoodsModel;
import com.yunang.fangda.business.goods.service.GoodsService;
import com.yunang.fangda.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:GoodsServiceImpl<br>
 * Date:2019/3/23 10:14<br>
 * Copyright (c) 2019 Baishun<br>
 *
 * @author cxc
 */
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsJpa jpa;
    @Override
    public ResponseResult<List<GoodsModel>> findAllByBusId(String busid) {
        List<GoodsModel> byBusid = jpa.findByBusid(busid);
        if (byBusid.size()>0){
            return new ResponseResult<>(true,"成功",byBusid);
        }else {
        return new ResponseResult<>(false,"没有商品",null);
        }
    }

    @Override
    public ResponseResult<GoodsModel> save(GoodsModel goodsModel) {
        GoodsModel save = jpa.save(goodsModel);
        return new ResponseResult<>(true,"成功",save);
    }

    @Override
    public ResponseResult<GoodsModel> delete(String uuid) {
        if (uuid == null || uuid.isEmpty())
            return new ResponseResult<>(false, "删除条件不能为空", null);
        jpa.deleteById(uuid);
        return new ResponseResult<>(true, "成功", null);
    }
}
