package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.FeedstockoutDao;
import com.hua.chick.chicken.entity.FeedstockoutEntity;
import com.hua.chick.chicken.service.FeedstockoutService;


@Service("feedstockoutService")
public class FeedstockoutServiceImpl extends ServiceImpl<FeedstockoutDao, FeedstockoutEntity> implements FeedstockoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedstockoutEntity> page = this.page(
                new Query<FeedstockoutEntity>().getPage(params),
                new QueryWrapper<FeedstockoutEntity>()
        );

        return new PageUtils(page);
    }

}