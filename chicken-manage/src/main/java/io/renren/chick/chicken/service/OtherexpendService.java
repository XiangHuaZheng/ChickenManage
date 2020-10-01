package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.OtherexpendEntity;

import java.util.Map;

/**
 * 其他支出
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
public interface OtherexpendService extends IService<OtherexpendEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

