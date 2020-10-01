package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鸡蛋当前库存
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("EggsStock")
public class EggsstockEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 种类
	 */
	@TableId
	private String category;
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

}
