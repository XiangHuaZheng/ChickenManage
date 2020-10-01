package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 各项收入
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Data
@TableName("Income")
public class IncomeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 收入类型
	 */
	@TableId
	private String incomeCategory;
	/**
	 * 收入金额合计
	 */
	private BigDecimal incomePrice;
	/**
	 * 开始日期
	 */
	private Date beginTime;
	/**
	 * 截止日期
	 */
	private Date endTime;

}
