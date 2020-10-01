package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.FeedoutdetailDao;
import com.hua.chick.chicken.entity.FeedoutdetailEntity;
import com.hua.chick.chicken.service.FeedoutdetailService;


@Service("feedoutdetailService")
public class FeedoutdetailServiceImpl extends ServiceImpl<FeedoutdetailDao, FeedoutdetailEntity> implements FeedoutdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedoutdetailEntity> page = this.page(
                new Query<FeedoutdetailEntity>().getPage(params),
                new QueryWrapper<FeedoutdetailEntity>()
        );

        return new PageUtils(page);
    }

}