package com.hua.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.common.utils.PageUtils;
import com.hua.chick.chicken.entity.SelldetailEntity;

import java.util.Map;

/**
 * 售鸡登记明细
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
public interface SelldetailService extends IService<SelldetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

