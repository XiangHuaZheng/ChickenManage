package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 孵化报表汇总
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("HatchSummery")
public class HatchsummeryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 批次号
	 */
	private Long batchNo;
	/**
	 * 箱号
	 */
	private String caseNo;
	/**
	 * 上箱时间
	 */
	private Date caseTime;
	/**
	 * 照蛋数量
	 */
	private Long eggNum;
	/**
	 * 受精率
	 */
	private BigDecimal fertilizationRate;
	/**
	 * 预计出鸡数
	 */
	private Long chikenNum;
	/**
	 * 出鸡率
	 */
	private BigDecimal chickenRate;
	/**
	 * 出鸡时间
	 */
	private Date chickenTime;
	/**
	 * 备注
	 */
	private String remarks;

}
