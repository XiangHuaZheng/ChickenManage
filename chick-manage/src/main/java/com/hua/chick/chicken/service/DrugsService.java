package com.hua.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.common.utils.PageUtils;
import com.hua.chick.chicken.entity.DrugsEntity;

import java.util.Map;

/**
 * 药品信息
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
public interface DrugsService extends IService<DrugsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

