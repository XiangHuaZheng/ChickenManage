package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 其他收入
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Data
@TableName("OtherIncome")
public class OtherincomeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 收入日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date incomeTime;
	/**
	 * 收入类型
	 */
	private String incomeCategory;
	/**
	 * 收入金额
	 */
	private BigDecimal incomePrice;
	/**
	 * 经办人
	 */
	private String agent;
	/**
	 * 备注
	 */
	private String remarks;

}
