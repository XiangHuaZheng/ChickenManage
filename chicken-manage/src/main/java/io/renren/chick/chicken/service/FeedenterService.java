package io.renren.chick.chicken.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.chick.chicken.entity.FeedenterdetailEntity;
import io.renren.chick.chicken.to.PassNumTo;
import io.renren.chick.chicken.vo.FeedEnterVo;
import io.renren.common.utils.PageUtils;
import io.renren.chick.chicken.entity.FeedenterEntity;

import java.util.Map;

/**
 * 饲料入库
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
public interface FeedenterService extends IService<FeedenterEntity> {

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

    FeedenterdetailEntity getDetailById(Map<String, Object> params);

    void saveFeedEnterVo(FeedEnterVo feedenter);

    void updateFeedEnterVoById(FeedEnterVo feedenter);
}

