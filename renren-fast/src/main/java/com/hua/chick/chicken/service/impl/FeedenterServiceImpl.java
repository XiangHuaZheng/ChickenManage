package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.FeedenterDao;
import com.hua.chick.chicken.entity.FeedenterEntity;
import com.hua.chick.chicken.service.FeedenterService;


@Service("feedenterService")
public class FeedenterServiceImpl extends ServiceImpl<FeedenterDao, FeedenterEntity> implements FeedenterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedenterEntity> page = this.page(
                new Query<FeedenterEntity>().getPage(params),
                new QueryWrapper<FeedenterEntity>()
        );

        return new PageUtils(page);
    }

}