package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.FeedstockinDao;
import com.hua.chick.chicken.entity.FeedstockinEntity;
import com.hua.chick.chicken.service.FeedstockinService;


@Service("feedstockinService")
public class FeedstockinServiceImpl extends ServiceImpl<FeedstockinDao, FeedstockinEntity> implements FeedstockinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedstockinEntity> page = this.page(
                new Query<FeedstockinEntity>().getPage(params),
                new QueryWrapper<FeedstockinEntity>()
        );

        return new PageUtils(page);
    }

}