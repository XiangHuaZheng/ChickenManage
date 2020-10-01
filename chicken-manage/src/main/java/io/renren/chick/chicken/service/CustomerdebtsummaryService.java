package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.CustomerdebtsummaryEntity;

import java.util.Map;

/**
 * 客户欠款汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
public interface CustomerdebtsummaryService extends IService<CustomerdebtsummaryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

