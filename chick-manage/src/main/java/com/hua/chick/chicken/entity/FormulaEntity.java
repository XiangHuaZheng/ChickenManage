package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 配方信息
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("Formula")
public class FormulaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 配方编号
	 */
	private Long formulaNo;
	/**
	 * 配方名称
	 */
	private String name;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 配置规格
	 */
	private String specifications;
	/**
	 * 总金额
	 */
	private BigDecimal sumPay;
	/**
	 * 备注
	 */
	private String remarks;

}
