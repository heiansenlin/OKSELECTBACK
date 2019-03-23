package com.yunang.fangda.business.goods.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
        @ApiModelProperty(value = "主键", example = "除新增外必填，由后台自动生成")
        @Id
        @GenericGenerator(name = "system-uuid", strategy = "uuid2")
        @GeneratedValue(generator = "system-uuid")
        private String uuid;
        //商品名称
        @ApiModelProperty(value = "商品名称",example = "商品名称")
        @Column(name = "cname",length = 32)
        private String cname;
        //商品价格
        @ApiModelProperty(value = "价格",example = "价格")
        @Column(name = "jg",length = 32)
        private Double jg;
        //商品单位
        @ApiModelProperty(value = "单位",example = "单位")
        @Column(name = "dw",length = 32)
        private String dw;
        //商品规格
        @ApiModelProperty(value = "规格",example = "规格")
        @Column(name = "ge",length = 32)
        private String ge;
        //商品主图
        @ApiModelProperty(value = "主图",example = "主图")
        @Column(name = "zt",length = 32)
        private String zt;
        //商品品牌
        @ApiModelProperty(value = "商品品牌",example = "商品品牌")
        @Column(name = "pp",length = 32)
        private String pp;
        //商品详情
        @ApiModelProperty(value = "商品详情",example = "商品详情")
        @Column(name = "xq",length = 32)
        private String xq;
        //商品销量
        @ApiModelProperty(value = "商品销量",example = "商品销量")
        @Column(name = "xl",length = 32)
        private String xl;
        //所属商家
        @ApiModelProperty(value = "所属商家",example = "所属商家")
        @Column(name = "busid",length = 32)
        private String busid;
        //商品数量
        @ApiModelProperty(value = "商品数量",example = "商品数量")
        @Column(name = "sl",length = 32)
        private int sl;
        //商品类目
        @ApiModelProperty(value = "商品类目",example = "商品类目")
        @Column(name = "lm",length = 32)
        private String lm;
        //商品上架、下架 0:上架，1：下架
        @ApiModelProperty(value = "上下架",example = "上下架")
        @Column(name = "sxj",length = 32)
        private int sxj;
}
