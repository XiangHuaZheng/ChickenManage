package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.OtherincomeEntity;

import java.util.Map;

/**
 * 其他收入
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
public interface OtherincomeService extends IService<OtherincomeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

