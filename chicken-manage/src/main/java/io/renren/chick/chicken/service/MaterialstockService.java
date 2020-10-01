package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.MaterialstockEntity;

import java.util.Map;

/**
 * 原料当前库存
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
public interface MaterialstockService extends IService<MaterialstockEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

