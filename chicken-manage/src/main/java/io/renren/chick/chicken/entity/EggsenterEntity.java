package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 鸡蛋生产入库
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Data
@TableName("EggsEnter")
public class EggsenterEntity implements Serializable {
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
	 * 入库日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date enterDate;
	/**
	 * 鸡舍号
	 */
	private Long chickenNo;
	/**
	 * 入库类型
	 */
	private String enterCategory;
	/**
	 * 经办人
	 */
	private String agent;
	/**
	 * 备注
	 */
	private String remarks;

}
