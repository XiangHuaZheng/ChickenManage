package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 各项支出
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Data
@TableName("Expend")
public class ExpendEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 支出类型
	 */
	@TableId
	private String expendCategory;
	/**
	 * 支出金额合计
	 */
	private BigDecimal expendPrice;
	/**
	 * 开始日期
	 */
	private Date beginTime;
	/**
	 * 截止日期
	 */
	private Date endTime;

}
