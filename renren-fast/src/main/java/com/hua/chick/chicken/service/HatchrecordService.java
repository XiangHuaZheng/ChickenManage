package com.hua.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.common.utils.PageUtils;
import com.hua.chick.chicken.entity.HatchrecordEntity;

import java.util.Map;

/**
 * 孵化记录表
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
public interface HatchrecordService extends IService<HatchrecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

