package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 配方信息明细
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("FormulaDetail")
public class FormuladetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 配方信息
	 */
	private Long formulaNo;
	/**
	 * 原料编号
	 */
	private Long materialNo;
	/**
	 * 原料名称
	 */
	private String materialName;
	/**
	 * 配料量
	 */
	private Long materialNum;
	/**
	 * 计量单位
	 */
	private String unit;
	/**
	 * 单价
	 */
	private BigDecimal unitPrice;
	/**
	 * 金额
	 */
	private BigDecimal price;

}
