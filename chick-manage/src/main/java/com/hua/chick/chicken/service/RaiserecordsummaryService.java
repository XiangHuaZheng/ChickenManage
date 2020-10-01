package com.hua.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.common.utils.PageUtils;
import com.hua.chick.chicken.entity.RaiserecordsummaryEntity;

import java.util.Map;

/**
 * 饲养记录汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
public interface RaiserecordsummaryService extends IService<RaiserecordsummaryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

