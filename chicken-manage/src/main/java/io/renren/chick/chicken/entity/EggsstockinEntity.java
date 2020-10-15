package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 鸡蛋入库汇总
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Data
@TableName("EggsStockIn")
public class EggsstockinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 入库日期
	 */
	@TableId
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date inDate;
	/**
	 * 入库单号
	 */
	private String inNo;
	/**
	 * 鸡舍号
	 */
	private Long chickenNo;
	/**
	 * 入库类型
	 */
	private String inCategory;
	/**
	 * 经办人
	 */
	private String agent;
	/**
	 * 种类
	 */
	private String category;
	/**
	 * 产蛋个数
	 */
	private Long eggsNum;
	/**
	 * 产蛋重量
	 */
	private BigDecimal eggsWeight;
	/**
	 * 备注
	 */
	private String remarks;

}
