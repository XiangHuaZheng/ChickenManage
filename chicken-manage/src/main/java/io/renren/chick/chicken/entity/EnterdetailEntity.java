package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 进鸡登记明细
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@Data
@TableName("EnterDetail")
public class EnterdetailEntity implements Serializable {
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
