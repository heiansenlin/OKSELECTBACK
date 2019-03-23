package com.yunang.fangda.business.goods.model;

import io.swagger.annotations.Api;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Title:GoodsModel<br>
 * Date:2019/3/23 10:08<br>
 * Copyright (c) 2019 Baishun<br>
 *
 * @author cxc
 */
@Api(value = "商品表")
@Slf4j
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "business_commodity_table")
@Table(comment = "商品表",appliesTo = "business_commodity_table")
public class GoodsModel {
        //商品主键
        private String uuid;
        //商品名称
        private String cname;
        //商品价格
        private Double jg;
        //商品单位
        private String dw;
        //商品规格
        private String ge;
        //商品主图
        private String zt;
        //商品品牌
        private String pp;
        //商品详情
        private String xq;
        //商品销量
        private String xl;
        //所属商家
        private String busid;
        //商品数量
        private int sl;
        //商品类目
        private String lm;
        //商品上架、下架 0:上架，1：下架
        private int sxj;
}
