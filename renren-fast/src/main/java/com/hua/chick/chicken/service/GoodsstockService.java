package com.hua.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.common.utils.PageUtils;
import com.hua.chick.chicken.entity.GoodsstockEntity;

import java.util.Map;

/**
 * 货品当前库存
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
public interface GoodsstockService extends IService<GoodsstockEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

