package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.FeedstockEntity;

import java.util.Map;

/**
 * 饲料当前库存
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
public interface FeedstockService extends IService<FeedstockEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

