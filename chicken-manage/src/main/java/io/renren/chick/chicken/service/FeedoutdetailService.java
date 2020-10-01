package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.FeedoutdetailEntity;

import java.util.Map;

/**
 * 饲料出库明细
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
public interface FeedoutdetailService extends IService<FeedoutdetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

