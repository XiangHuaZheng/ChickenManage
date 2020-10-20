package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 饲料出库
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@Data
@TableName("FeedOut")
public class FeedoutEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 入库单号
	 */
	private Long outNo;
	/**
	 * 入库日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date outDate;
	/**
	 * 入库类型
	 */
	private String outCategory;
	/**
	 * 供商编号
	 */
	private Long supplierNo;
	/**
	 * 供商名称
	 */
	private String supplierName;
	/**
	 * 经办人
	 */
	private String agent;
	/**
	 * 备注
	 */
	private String remarks;

	/*
	 * 审核状态
	 * */
	private Integer pass;
	/*
	 * 确认状态
	 * */
	private Integer certain;
}
