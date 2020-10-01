package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.EntercostEntity;

import java.util.Map;

/**
 * 进鸡成本统计
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
public interface EntercostService extends IService<EntercostEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

