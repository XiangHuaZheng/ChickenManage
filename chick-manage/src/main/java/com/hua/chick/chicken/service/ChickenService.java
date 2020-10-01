package com.hua.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.common.utils.PageUtils;
import com.hua.chick.chicken.entity.ChickenEntity;

import java.util.Map;

/**
 * 鸡舍信息
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
public interface ChickenService extends IService<ChickenEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

