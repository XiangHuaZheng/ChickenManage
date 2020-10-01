package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.DrugsenterEntity;

import java.util.Map;

/**
 * 药品入库
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
public interface DrugsenterService extends IService<DrugsenterEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

