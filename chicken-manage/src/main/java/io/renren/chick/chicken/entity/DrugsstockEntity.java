package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 药品当前库存
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Data
@TableName("DrugsStock")
public class DrugsstockEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
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
	 * 单价
	 */
	private BigDecimal unitPrice;
	/**
	 * 计量单位
	 */
	private String unit;
	/**
	 * 当前库存
	 */
	private Long stockNum;
	/**
	 * 累计入库
	 */
	private Long stockIn;
	/**
	 * 累计出库
	 */
	private Long stockOut;
	/**
	 * 批准文号
	 */
	private String approvalNumber;
	/**
	 * 生产厂家
	 */
	private String manufacturer;

}
