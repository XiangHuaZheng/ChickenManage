package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.chick.chicken.vo.EnterVo;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.EnterEntity;

import java.util.List;
import java.util.Map;

/**
 * 进鸡登记
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
public interface EnterService extends IService<EnterEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils todayList(Map<String, Object> params);

    PageUtils monthList(Map<String, Object> params);

    PageUtils yearList(Map<String, Object> params);

    void passById(Long id);

    void saveEnterVo(EnterVo enter);

    void updateEnterVoById(EnterVo enter);

    void certainById(Long id);
}

