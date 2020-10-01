package com.hua.chick.chicken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 供应商信息
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Data
@TableName("Supplier")
public class SupplierEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 供商编号
	 */
	private Long supplierNo;
	/**
	 * 供商名称
	 */
	private String name;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 联系人
	 */
	private String contacts;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 开户银行
	 */
	private String bank;
	/**
	 * 银行账户
	 */
	private String account;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 备注
	 */
	private String remarks;

}
