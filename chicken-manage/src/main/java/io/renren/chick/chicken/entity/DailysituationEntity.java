package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 日常情况
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Data
@TableName("DailySituation")
public class DailysituationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 鸡舍名称
	 */
	private String chickenName;
	/**
	 * 批次号
	 */
	private Long batchId;
	/**
	 * 日期
	 */
	private Date dailyDate;
	/**
	 * 饲养员
	 */
	private String breeder;
	/**
	 * 日龄
	 */
	private String raiseDays;
	/**
	 * 存栏鸡数
	 */
	private String chickenNum;
	/**
	 * 死亡数
	 */
	private String dieNum;
	/**
	 * 淘汰数
	 */
	private String outNum;
	/**
	 * 出售数
	 */
	private String sellNum;
	/**
	 * 转入数
	 */
	private String inNum;
	/**
	 * 产蛋数
	 */
	private String eggNum;
	/**
	 * 早温度
	 */
	private String earlyTemp;
	/**
	 * 中温度
	 */
	private String medTemp;
	/**
	 * 晚温度
	 */
	private String lateTemp;
	/**
	 * 早湿度
	 */
	private String earlyHumidity;
	/**
	 * 中湿度
	 */
	private String medHumidity;
	/**
	 * 晚湿度
	 */
	private String lateHumidity;
	/**
	 * 防疫记录
	 */
	private String epidemicPreventionRecord;
	/**
	 * 用药记录
	 */
	private String medicationRecord;
	/**
	 * 采食量
	 */
	private String feedIntake;
	/**
	 * 消毒情况
	 */
	private String disinfect;
	/**
	 * 备注
	 */
	private String remarks;

}
