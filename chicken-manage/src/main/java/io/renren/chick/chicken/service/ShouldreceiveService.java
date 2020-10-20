package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.ShouldreceiveEntity;

import java.util.Map;

/**
 * 应收表
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-16 15:05:11
 */
public interface ShouldreceiveService extends IService<ShouldreceiveEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

