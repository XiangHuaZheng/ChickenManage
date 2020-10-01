package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 饲料入库汇总
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@Data
@TableName("FeedStockIn")
public class FeedstockinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 入库日期
	 */
	@TableId
	private Date inDate;
	/**
	 * 入库单号
	 */
	private String inNo;
	/**
	 * 入库类型
	 */
	private String inCategory;
	/**
	 * 供商名称
	 */
	private String supplierName;
	/**
	 * 编号
	 */
	private String stockInNo;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 规格
	 */
	private String specifications;
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 数量
	 */
	private Long unitNum;
	/**
	 * 单价
	 */
	private BigDecimal unitPrice;
	/**
	 * 金额
	 */
	private BigDecimal price;

}
