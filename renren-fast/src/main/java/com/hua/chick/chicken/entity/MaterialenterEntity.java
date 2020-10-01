package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 原料入库
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("MaterialEnter")
public class MaterialenterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 入库单号
	 */
	private Long enterNo;
	/**
	 * 入库日期
	 */
	private Date enterDate;
	/**
	 * 入库类型
	 */
	private String enterCategory;
	/**
	 * 供商编号
	 */
	private Long supplierNo;
	/**
	 * 供商名称
	 */
	private String supplierName;
	/**
	 * 经办人
	 */
	private String agent;
	/**
	 * 应付金额
	 */
	private BigDecimal sumPay;
	/**
	 * 已付金额
	 */
	private BigDecimal hasPay;
	/**
	 * 未付金额
	 */
	private BigDecimal noPay;
	/**
	 * 备注
	 */
	private String remarks;

}
