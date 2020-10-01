package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.DrugsEntity;

import java.util.Map;

/**
 * 药品信息
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
public interface DrugsService extends IService<DrugsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

