package com.yunang.fangda.business.order.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.Version;

/**
 * Title:OrderModel<br>
 * Date:2019/3/22 11:14<br>
 * Copyright (c) 2019 Baishun<br>
 *
 * @author cxc
 */
@Api(value = "订单表")
@Slf4j
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customer_order_table")
@Table(comment = "订单表",appliesTo = "customer_order_table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderModel {
        //主键
        private String uuid;
        //商品ID
        private String spid;
        //购买数量
        private String sl;
        //配送费
        private Double psf;
        //优惠券ID
        private String yhqid;
        //总价
        private String zj;
        //配送地址
        private String address;
        //订单编号
        private String ddbh;
        //创建时间
        private String cjTime;
        //用户id
        private String account;
        //用户电话
        private String accountphone;
        //商家id
        private String busid;
        //订单状态  0:未完成，1：已完成，2：已关闭
        private int type;
        @ApiModelProperty(value = "数据版本信息", example = "修改删除时必填，从后台获取")
        @Version
        private Long version;
}
