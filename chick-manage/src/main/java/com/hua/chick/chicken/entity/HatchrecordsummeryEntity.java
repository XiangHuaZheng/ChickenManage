package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 孵化记录表汇总
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("HatchRecordSummery")
public class HatchrecordsummeryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 时间
	 */
	private Date hatchTime;
	/**
	 * 温度
	 */
	private String hatchTemp;
	/**
	 * 湿度
	 */
	private String hatchHumidity;
	/**
	 * 风门位置
	 */
	private String doorLocation;
	/**
	 * 翻单次数及位置
	 */
	private String numLocation;
	/**
	 * 运转情况
	 */
	private String operation;
	/**
	 * 机号
	 */
	private String machineNo;
	/**
	 * 值班员
	 */
	private String duty;
	/**
	 * 接班时间
	 */
	private Date changeDutyTime;
	/**
	 * 备注
	 */
	private String remarks;

}
