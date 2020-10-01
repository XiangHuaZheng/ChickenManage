package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鸡舍信息
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("Chicken")
public class ChickenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 鸡舍号
	 */
	private Long chickenNo;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 最大存储量
	 */
	private String maxStore;
	/**
	 * 位置
	 */
	private String location;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 备注
	 */
	private String remarks;

}
