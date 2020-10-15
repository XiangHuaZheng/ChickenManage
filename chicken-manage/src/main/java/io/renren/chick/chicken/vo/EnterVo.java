package io.renren.chick.chicken.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EnterVo {
    private Long id;
    /**
     * 批次号
     */
    private Long batchNo;
    /**
     * 进鸡日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enterDate;
    /**
     * 供商编号
     */
    private Long supplierNo;
    /**
     * 供商名称
     */
    private String supplierName;
    /**
     * 品种
     */
    private String varieties;
    /**
     * 数量
     */
    private Long num;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 应付金额
     */
    private BigDecimal sumPay;
    /**
     * 已付金额
     */
    private BigDecimal hasPay;
    /**
     * 未付金额
     */
    private BigDecimal noPay;
    /**
     * 成长天数
     */
    private String growDays;
    /**
     * 备注
     */
    private String remarks;
    /*
     * 审核状态
     * */
    private Integer pass;


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
    private String remarks2;
}
