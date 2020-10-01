package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鸡蛋入库明细
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("EggsEnterDetail")
public class EggsenterdetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 单号
	 */
	private Long enterNo;
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
