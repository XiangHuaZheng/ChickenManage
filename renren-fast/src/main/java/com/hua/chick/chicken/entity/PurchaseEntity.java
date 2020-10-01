package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 期间采购查询
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("Purchase")
public class PurchaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 批次号
	 */
	@TableId
	private Long batchNo;
	/**
	 * 进鸡日期
	 */
	private Date enterDate;
	/**
	 * 品种
	 */
	private String varieties;
	/**
	 * 供商名称
	 */
	private String supplierName;
	/**
	 * 鸡舍号
	 */
	private Long chickenNo;
	/**
	 * 存储量
	 */
	private Long storeNum;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 备注
	 */
	private String remarks;

}
