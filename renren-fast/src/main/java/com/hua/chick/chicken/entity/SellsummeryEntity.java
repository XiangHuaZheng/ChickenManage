package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 期间销售汇总
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("SellSummery")
public class SellsummeryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 销售单号
	 */
	@TableId
	private Long sellNo;
	/**
	 * 销售日期
	 */
	private Date sellDate;
	/**
	 * 销售类型
	 */
	private String sellCategory;
	/**
	 * 客户编号
	 */
	private Long supplierNo;
	/**
	 * 客户名称
	 */
	private String supplierName;
	/**
	 * 鸡舍号
	 */
	private Long chickenNo;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 销售数量
	 */
	private Long sellNum;
	/**
	 * 总重量
	 */
	private BigDecimal sellSum;
	/**
	 * 销售单价
	 */
	private BigDecimal eggsPrice;
	/**
	 * 金额
	 */
	private BigDecimal price;

}
