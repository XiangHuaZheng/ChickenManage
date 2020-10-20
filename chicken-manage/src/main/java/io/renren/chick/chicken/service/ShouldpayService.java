package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.ShouldpayEntity;

import java.util.Map;

/**
 * 应付表
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-16 15:05:11
 */
public interface ShouldpayService extends IService<ShouldpayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

