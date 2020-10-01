package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 售鸡登记明细
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("SellDetail")
public class SelldetailEntity implements Serializable {
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
	 * 鸡舍号
	 */
	private Long chickenNo;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 销售数量
	 */
	private Long sellNum;
	/**
	 * 总重量
	 */
	private BigDecimal sellSum;
	/**
	 * 销售单价
	 */
	private BigDecimal eggsPrice;
	/**
	 * 金额
	 */
	private BigDecimal price;

}
