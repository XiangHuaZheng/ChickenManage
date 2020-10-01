package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.DrugsfailurealertEntity;

import java.util.Map;

/**
 * 药品失效提醒
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
public interface DrugsfailurealertService extends IService<DrugsfailurealertEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

