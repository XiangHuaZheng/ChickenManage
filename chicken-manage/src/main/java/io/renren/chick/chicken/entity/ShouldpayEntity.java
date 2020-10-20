package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 应付表
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-16 15:05:11
 */
@Data
@TableName("ShouldPay")
public class ShouldpayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 费用名称
	 */
	private String name;
	/**
	 * 费用类型 
	 */
	private Integer category;
	/**
	 * 日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date time;
	/**
	 * 应收金额
	 */
	private BigDecimal incomePrice;

}
