package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.chick.chicken.entity.EnterdetailEntity;
import io.renren.chick.chicken.entity.FeedoutdetailEntity;
import io.renren.chick.chicken.to.PassNumTo;
import io.renren.chick.chicken.vo.EnterVo;
import io.renren.chick.chicken.vo.FeedOutVo;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.FeedoutEntity;

import java.util.Map;

/**
 * 饲料出库
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
public interface FeedoutService extends IService<FeedoutEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils certainList(Map<String, Object> params);

    PageUtils todayList(Map<String, Object> params);

    PassNumTo todayCertainList(Map<String, Object> params);

    PageUtils monthList(Map<String, Object> params);

    PageUtils monthCertainList(Map<String, Object> params);

    PageUtils yearList(Map<String, Object> params);

    PageUtils yearCertainList(Map<String, Object> params);

    PageUtils passList(Map<String, Object> params);

    void passById(Long id);

    void certainById(Long id);

    FeedoutdetailEntity getDetailById(Map<String, Object> params);

    public void updateFeedOutVoById(FeedOutVo enter);

    public void saveFeedOutVo(FeedOutVo enter) ;
}

