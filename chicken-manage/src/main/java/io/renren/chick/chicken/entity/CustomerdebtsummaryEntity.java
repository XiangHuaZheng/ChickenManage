package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 客户欠款汇总
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Data
@TableName("CustomerDebtSummary")
public class CustomerdebtsummaryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 客户编号
	 */
	@TableId
	private Long supplierNo;
	/**
	 * 客户名称
	 */
	private String supplierName;
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

}
