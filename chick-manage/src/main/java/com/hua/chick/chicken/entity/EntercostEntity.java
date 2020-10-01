package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 进鸡成本统计
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("EnterCost")
public class EntercostEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 进鸡日期
	 */
	@TableId
	private Date enterDate;
	/**
	 * 品种
	 */
	private String varieties;
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

}
