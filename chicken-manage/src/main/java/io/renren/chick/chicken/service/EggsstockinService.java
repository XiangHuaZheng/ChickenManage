package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.EggsstockinEntity;

import java.util.Map;

/**
 * 鸡蛋入库汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
public interface EggsstockinService extends IService<EggsstockinEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

