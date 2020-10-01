package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鸡蛋销售出库
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Data
@TableName("EggsOut")
public class EggsoutEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 销售单号
	 */
	private Long outNo;
	/**
	 * 销售日期
	 */
	private Date outDate;
	/**
	 * 销售类型
	 */
	private String outCategory;
	/**
	 * 客户编号
	 */
	private Long supplierNo;
	/**
	 * 客户名称
	 */
	private String supplierName;
	/**
	 * 经办人
	 */
	private String agent;
	/**
	 * 鸡舍号
	 */
	private Long chickenNo;
	/**
	 * 种类
	 */
	private String category;
	/**
	 * 销售数量
	 */
	private Long sellNum;
	/**
	 * 单价
	 */
	private BigDecimal eggsPrice;
	/**
	 * 应付金额
	 */
	private BigDecimal sumPay;
	/**
	 * 已付金额
	 */
	private BigDecimal hasPay;
	/**
	 * 欠收金额
	 */
	private BigDecimal noPay;
	/**
	 * 备注
	 */
	private String remarks;

}
