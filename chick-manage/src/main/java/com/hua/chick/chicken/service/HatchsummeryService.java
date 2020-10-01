package com.hua.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.common.utils.PageUtils;
import com.hua.chick.chicken.entity.HatchsummeryEntity;

import java.util.Map;

/**
 * 孵化报表汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
public interface HatchsummeryService extends IService<HatchsummeryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
