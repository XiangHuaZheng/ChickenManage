package io.renren.chick.chicken.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FeedOutVo {
    private Long id;
    /**
     * 入库单号
     */
    private Long outNo;
    /**
     * 入库日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date outDate;
    /**
     * 入库类型
     */
    private String outCategory;
    /**
     * 供商编号
     */
    private Long supplierNo;
    /**
     * 供商名称
     */
    private String supplierName;
    /**
     * 经办人
     */
    private String agent;
    /**
     * 备注
     */
    private String remarks;

    /*
     * 审核状态
     * */
    private Integer pass;
    /*
     * 确认状态
     * */
    private Integer certain;



    /**
     * 编号
     */
    private String detailNo;
    /**
     * 名称
     */
    private String name;
    /**
     * 类别
     */
    private String category;
    /**
     * 规格
     */
    private String specifications;
    /**
     * 单位
     */
    private String unit;
    /**
     * 数量
     */
    private BigDecimal unitNum;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
}
