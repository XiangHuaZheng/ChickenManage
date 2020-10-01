package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.DailysituationEntity;

import java.util.Map;

/**
 * 日常情况
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
public interface DailysituationService extends IService<DailysituationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

