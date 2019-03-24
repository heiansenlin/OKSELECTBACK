package com.yunang.fangda.business.goods.controller;

import com.yunang.fangda.business.account.model.AccountModel;
import com.yunang.fangda.business.goods.model.GoodsModel;
import com.yunang.fangda.business.goods.service.GoodsService;
import com.yunang.fangda.sys.shiro.JWTUtils;
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
 * Title:GoodsController<br>
 * Date:2019/3/23 10:33<br>
 * Copyright (c) 2019 Baishun<br>
 *
 * @author cxc
 */
@Api(value = "商品接口",description = "商品接口")
@Slf4j
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService service;

    @ApiOperation("查询商户所有商品")
    @RequestMapping(value = "/findAllByBusId",method = RequestMethod.GET)
    public ResponseResult<List<GoodsModel>> findAllByBusId(HttpServletRequest request){
        String busid = JWTUtils.getAccId(request);
        return service.findAllByBusId(busid);
    }

    @ApiOperation("增加商户商品")
    @RequestMapping(value = "/goods",method = RequestMethod.POST)
    public ResponseResult<GoodsModel> save(
            @ApiParam(value = "商家ID",required = true,example = "商家ID")
            @RequestBody GoodsModel goodsModel){
        return service.save(goodsModel);
    }

    /**
     * 根据id删除
     *
     * @param uuid
     * @return
     */
    @ApiOperation(value = "根据商品主键删除")
//    @RequiresRoles(value = {"admin"})
//    @RequiresPermissions(value = "account-delete")
    @RequestMapping(value = "/goods/{uuid}", method = RequestMethod.DELETE)
    public ResponseResult<GoodsModel> delete(@ApiParam(value = "账号主键", required = true, example = "后台获取的主键")
                                               @PathVariable("uuid") String uuid) {
        return service.delete(uuid);
    }
}
