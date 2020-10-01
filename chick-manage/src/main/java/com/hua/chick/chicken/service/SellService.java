package com.hua.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.common.utils.PageUtils;
import com.hua.chick.chicken.entity.SellEntity;

import java.util.Map;

/**
 * 销售登记
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
public interface SellService extends IService<SellEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

