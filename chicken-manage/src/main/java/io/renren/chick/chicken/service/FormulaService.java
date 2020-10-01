package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.FormulaEntity;

import java.util.Map;

/**
 * 配方信息
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
public interface FormulaService extends IService<FormulaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

