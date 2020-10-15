package io.renren.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 员工信息
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@Data
@TableName("Staff")
public class StaffEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 员工编号
	 */
	private Long staffNo;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 0:男性  1:女性
	 */
	private Integer gender;
	/**
	 * 联系方式
	 */
	private String phone;
	/**
	 * 职务
	 */
	private String job;
	/**
	 * 负责鸡舍
	 */
	private Long henhouse;
	/**
	 * 入职日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date jobDate;
	/**
	 * 0:在职  1:离职
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remarks;

}
