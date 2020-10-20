package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 应收应付表
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-16 15:05:11
 */
@Data
@TableName("ReceivePaySummery")
public class ReceivepaysummeryEntity implements Serializable {
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
	 * 应收金额
	 */
	private BigDecimal incomePrice;
	/**
	 * 应付金额
	 */
	private BigDecimal expendPrice;
	/**
	 * 开始日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date beginTime;
	/**
	 * 截止日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endTime;

}
