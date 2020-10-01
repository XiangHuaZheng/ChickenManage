package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.FeedenterEntity;

import java.util.Map;

/**
 * 饲料入库
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
public interface FeedenterService extends IService<FeedenterEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

