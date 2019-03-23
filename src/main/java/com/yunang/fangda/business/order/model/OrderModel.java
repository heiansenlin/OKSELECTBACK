package com.yunang.fangda.business.order.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.sql.Timestamp;

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
        @ApiModelProperty(value = "主键", example = "除新增外必填，由后台自动生成")
        @Id
        @GenericGenerator(name = "system-uuid", strategy = "uuid2")
        @GeneratedValue(generator = "system-uuid")
        private String uuid;
        //商品ID
        @ApiModelProperty(value = "商品id",example = "商品ID")
        @Column(name = "spid",length = 32)
        private String spid;
        //购买数量
        @ApiModelProperty(value = "购买数量",example = "购买数量")
        @Column(name = "sl",length = 10)
        private String sl;
        //配送费
        @ApiModelProperty(value = "配送费",example = "配送费")
        @Column(name = "psf",length = 10)
        private Double psf;
        //优惠券ID
        @ApiModelProperty(value = "优惠券id",example = "优惠券id")
        @Column(name = "yhqid",length = 32)
        private String yhqid;
        //总价
        @ApiModelProperty(value = "总价",example = "总价")
        @Column(name = "zj",length = 32)
        private String zj;
        //配送地址
        @ApiModelProperty(value = "配送地址",example = "配送地址")
        @Column(name = "address",length = 255)
        private String address;
        //订单编号
        @ApiModelProperty(value = "订单编号",example = "订单编号")
        @Column(name = "ddbh",length = 32)
        private String ddbh;
        //创建时间
        @ApiModelProperty(value = "创建时间",example = "创建时间")
        @Column(name = "cj_time",length = 32)
        private Timestamp cjTime;
        //用户id
        @ApiModelProperty(value = "用户id",example = "用户id")
        @Column(name = "account_id",length = 32)
        private String accountId;
        //用户电话
        @ApiModelProperty(value = "用户电话",example = "用户电话")
        @Column(name = "account_phone",length = 12)
        private String accountPhone;
        //商家id
        @ApiModelProperty(value = "商家id",example = "商家ID")
        @Column(name = "busid",length = 32)
        private String busid;
        //订单状态  0:未完成，1：已完成，2：已关闭
        @ApiModelProperty(value = "订单状态",example = "订单状态")
        @Column(name = "type",length = 32)
        private int type;
        @ApiModelProperty(value = "数据版本信息", example = "修改删除时必填，从后台获取")
        @Version
        private Long version;
}
