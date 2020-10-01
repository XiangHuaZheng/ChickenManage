package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 饲养记录
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Data
@TableName("RaiseRecord")
public class RaiserecordEntity implements Serializable {
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
	 * 饲料名称
	 */
	private String feedsName;
	/**
	 * 编号
	 */
	private String raiseNo;
	/**
	 * 规格
	 */
	private String specifications;
	/**
	 * 喂养量
	 */
	private String raiseNum;
	/**
	 * 计量单位
	 */
	private String unit;
	/**
	 * 单价
	 */
	private BigDecimal unitPrice;
	/**
	 * 金额
	 */
	private BigDecimal price;
	/**
	 * 饲养员
	 */
	private String breeder;
	/**
	 * 备注
	 */
	private String remarks;

}
