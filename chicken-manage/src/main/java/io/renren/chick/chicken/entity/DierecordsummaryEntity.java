package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 死亡记录汇总
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Data
@TableName("DieRecordSummary")
public class DierecordsummaryEntity implements Serializable {
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
	 * 类别
	 */
	private String category;
	/**
	 * 日期
	 */
	private Date dailyDate;
	/**
	 * 死亡数量
	 */
	private String dieNum;
	/**
	 * 死亡原因
	 */
	private String dieReason;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 登记员
	 */
	private String recorder;

}
